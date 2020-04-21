package com.marathon.service.impl;

import com.google.common.collect.ImmutableMap;
import com.marathon.domain.MrtonProcCfgResource;
import com.marathon.mapper.MrtonProcCfgResourceMapper;
import com.marathon.qvo.OfficeFileAclVO;
import com.marathon.service.IReferOfficeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Map;

/**
 * @author cuiguangqiang
 * @version ReferOfficeServiceImpl, v0.1 2020/4/21 11:09
 * @description 类说明
 */
@Slf4j
@Component
public class ReferOfficeServiceImpl implements IReferOfficeService {

    @Value("${office.editorCaller}")
    private String editorCaller;

    @Value("${office.editorHost}")
    private String editorHost;

    @Autowired
    private MrtonProcCfgResourceMapper mrtonProcCfgResourceMapper;

    private Map<String, String> mapMimeType = ImmutableMap.<String, String>builder()
            .put("doc", "application/msword")
            .put("docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document")
            .put("xls", "application/vnd.ms-excel")
            .put("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
            .put("ppt", "application/vnd.ms-powerpoint")
            .put("pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation")
            .put("pdf", "application/pdf")
            .put("js", "application/javascript")
            .put("go", "text/plain")
            .build();

    @Override
    public OfficeFileAclVO fileAcl(String fileId, String userId) {
        MrtonProcCfgResource fileResource = mrtonProcCfgResourceMapper.selectByPrimaryKey(Integer.valueOf(fileId));

        OfficeFileAclVO vo = new OfficeFileAclVO();

        OfficeFileAclVO.User user = vo.new User();
        user.setUid(userId);
        user.setOid(userId);
        user.setNickName(userId);
        vo.setUser(user);

        OfficeFileAclVO.Doc doc = vo.new Doc();
        doc.setDocId(fileId);
        doc.setTitle(fileResource.getResourceName());

        String url = fileResource.getResourceUrl();
        String ext = url.substring(url.lastIndexOf(".") + 1);
        doc.setMimeType(mapMimeType.get(ext));
        doc.setFetchUrl(editorCaller + "/referoffice/file/download/?fileId=" + fileId);
        vo.setDoc(doc);

        return vo;
    }

    @Override
    public String getLink(String fileId, Integer userId, String operation) {

        MrtonProcCfgResource fileResource = mrtonProcCfgResourceMapper.selectByPrimaryKey(Integer.valueOf(fileId));

        String callURL = editorCaller + "/referoffice/fileAcl/" + fileId + "/" + userId;

        try {
            //url 64编码
            String base64CallURL = Base64.getEncoder().encodeToString(callURL.getBytes("utf-8"));

            String result = editorHost + "apps/editor/" + operation + "?callURL=" + base64CallURL;

            log.info("文件【{}】链接地址【{}】", fileResource.getResourceName(), result);

            return result;

        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("获取office文件链接出错！");
        }
    }
}

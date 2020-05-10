package com.marathon.service.impl;

import com.google.common.collect.ImmutableMap;
import com.marathon.config.BishengConfig;
import com.marathon.domain.MrtonResource;
import com.marathon.qvo.OfficeFileAclVO;
import com.marathon.qvo.OfficeFileSaveBackQO;
import com.marathon.qvo.OfficeFileSaveBackVO;
import com.marathon.service.IMrtonResourceService;
import com.marathon.service.IOfficeToolService;
import com.mton.common.config.Global;
import com.mton.common.utils.file.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Map;

/**
 * @author cuiguangqiang
 * @version OfficeToolServiceImpl, v0.1 2020/2/4 16:42
 * @description 类说明
 */
@Service
public class OfficeToolServiceImpl implements IOfficeToolService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BishengConfig bishengConfig;

    @Autowired
    private IMrtonResourceService mrtonResourceService;

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
    public String getLink(String fileId, Integer userId, String operation) {

        MrtonResource fileResource = mrtonResourceService.selectMrtonResourceById(Integer.valueOf(fileId));

        String callURL = bishengConfig.getEditorCaller() + "/office/fileAcl/" + fileId + "/" + userId;

        try {
            //url 64编码
            String base64CallURL = Base64.getEncoder().encodeToString(callURL.getBytes("utf-8"));

            String result = bishengConfig.getEditorHost() + "apps/editor/" + operation + "?callURL=" + base64CallURL;

            logger.info("文件【{}】链接地址【{}】", fileResource.getResourceName(), result);

            return result;

        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("获取office文件链接出错！");
        }
    }

    @Override
    public OfficeFileAclVO fileAcl(String fileId, String userId) {

        MrtonResource fileResource = mrtonResourceService.selectMrtonResourceById(Integer.valueOf(fileId));

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
        doc.setFetchUrl(bishengConfig.getEditorCaller() + "/office/file/download/?fileId=" + fileId);
        vo.setDoc(doc);

        return vo;

    }

    @Override
    public OfficeFileSaveBackVO saveBack(OfficeFileSaveBackQO qo) {
        OfficeFileSaveBackVO vo = new OfficeFileSaveBackVO();

        OfficeFileSaveBackQO.Data data = qo.getData();
        try {
            String docId = data.getDocId();

            //是否被修改
            if (!data.getUnchanged()) {
                String downloadUrl = data.getDocURL();
                String downloadUrlBase64 = data.getDocUrlEncode();
                if (Base64.getEncoder().encodeToString(downloadUrl.getBytes("utf-8")).equals(downloadUrlBase64)) {
                    throw new IllegalArgumentException("下载地址校验不通过！");
                }

                MrtonResource mrtonResource = mrtonResourceService.selectMrtonResourceById(Integer.valueOf(docId));
                String relavateFilePath = mrtonResource.getResourceUrl();
                String filePath = Global.getUploadPath() + relavateFilePath;

                //下载覆盖文件
                String fetchUrl = bishengConfig.getEditorHost()+data.getDocURL();
                FileUtils.downLoadFromUrl(fetchUrl, filePath);
                logger.info("文件【{}】被修改覆盖成功！", filePath);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vo;
    }
}

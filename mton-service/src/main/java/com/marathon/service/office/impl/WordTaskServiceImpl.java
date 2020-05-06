package com.marathon.service.office.impl;

import com.marathon.MrtonConstants;
import com.marathon.domain.*;
import com.marathon.mapper.MrtonProcCfgResourceMapper;
import com.marathon.mapper.MrtonWordItemMapper;
import com.marathon.service.IMrtonProcInfoService;
import com.marathon.service.IMrtonResourceService;
import com.marathon.service.IOfficeToolService;
import com.marathon.service.office.WordTaskService;
import com.marathon.service.office.WordToolService;
import com.mton.common.config.Global;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author cuiguangqiang
 * @version WordTaskServiceImpl, v0.1 2020/5/4 7:43
 * @description 类说明
 */

@Component
@Slf4j
public class WordTaskServiceImpl implements WordTaskService {

    @Autowired
    private IMrtonProcInfoService mrtonProcInfoService;

    @Autowired
    private MrtonProcCfgResourceMapper mrtonProcCfgResourceMapper;

    @Autowired
    private WordToolService wordToolService;

    @Autowired
    private MrtonWordItemMapper mrtonWordItemMapper;

    @Autowired
    private IMrtonResourceService mrtonResourceService;

    @Autowired
    private IOfficeToolService officeToolService;

    /**
     * 模板生成文档
     *
     * @param taskId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String genWordDoc(String taskId, Map<String, String> dataMap) {

        MrtonProcInfo mrtonProcInfo = mrtonProcInfoService.selectMrtonProcInfoById(taskId);
        String procCfgId = mrtonProcInfo.getProcId();

        MrtonProcCfgResourceExample example = new MrtonProcCfgResourceExample();
        example.or().andCfgProcIdEqualTo(procCfgId);
        List<MrtonProcCfgResource> resources = mrtonProcCfgResourceMapper.selectByExample(example);
        if (resources.size() != 1) {
            throw new IllegalArgumentException("任务【" + taskId + "】没有模板文件");
        }
        String templateUrl = Global.getUploadPath() + File.separator + resources.get(0).getResourceUrl();
        log.info("模板文件路径【{}】", templateUrl);

        String outputFilePathDir = Global.getUploadPath() + File.separator + taskId;
        if (!new File(outputFilePathDir).exists()) {
            new File(outputFilePathDir).mkdirs();
        }

        String outputFileName = "sys_" + System.currentTimeMillis() + ".docx";
        String outputFilePath = outputFilePathDir + File.separator + outputFileName;

        wordToolService.renderDocument(templateUrl, dataMap, outputFilePath);

        dataMap.forEach((k, v) -> {
            MrtonWordItem item = new MrtonWordItem();
            item.setProcId(taskId);
            item.setPlaceholderKey(k);
            item.setPlaceholderValue(v);
            mrtonWordItemMapper.insert(item);
        });

        MrtonResource resource = new MrtonResource();
        resource.setProcId(taskId);
        resource.setResourceName(resources.get(0).getResourceName());
        resource.setResourceUrl(taskId+File.separator+outputFileName);
        mrtonResourceService.insertMrtonResource(resource);

        return officeToolService.getLink(String.valueOf(resource.getId()),1, MrtonConstants.OFFICE_PREVIEW_KEY);
    }
}

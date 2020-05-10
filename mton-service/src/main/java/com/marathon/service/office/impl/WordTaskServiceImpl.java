package com.marathon.service.office.impl;

import com.marathon.MrtonConstants;
import com.marathon.config.SystemConfig;
import com.marathon.domain.*;
import com.marathon.mapper.MrtonProcCfgMapper;
import com.marathon.mapper.MrtonProcCfgResourceMapper;
import com.marathon.mapper.MrtonResourceMapper;
import com.marathon.mapper.MrtonWordItemMapper;
import com.marathon.service.*;
import com.marathon.service.office.WordTaskService;
import com.marathon.service.office.WordToolService;
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
    private IMarathonInfoService marathonInfoService;

    @Autowired
    private MrtonProcCfgMapper mrtonProcCfgMapper;

    @Autowired
    private MrtonProcCfgResourceMapper mrtonProcCfgResourceMapper;

    @Autowired
    private WordToolService wordToolService;

    @Autowired
    private MrtonWordItemMapper mrtonWordItemMapper;

    @Autowired
    private IMrtonResourceService mrtonResourceService;

    @Autowired
    private MrtonResourceMapper mrtonResourceMapper;

    @Autowired
    private IOfficeToolService officeToolService;

    @Autowired
    private SystemConfig systemConfig;

    /**
     * 模板生成文档
     *
     * @param taskId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String genWordDoc(String taskId, Map<String, String> dataMap) {

        MrtonProcInfo mrtonProcInfo = mrtonProcInfoService.selectMrtonProcInfoById(taskId);
        //任务模板信息
        String procCfgId = mrtonProcInfo.getProcId();

        MrtonProcCfgResourceExample example = new MrtonProcCfgResourceExample();
        example.or().andCfgProcIdEqualTo(procCfgId);
        //任务模板文件
        List<MrtonProcCfgResource> resources = mrtonProcCfgResourceMapper.selectByExample(example);
        if (resources.size() != 1) {
            throw new IllegalArgumentException("任务【" + taskId + "】没有模板文件");
        }
        String templateUrl = systemConfig.getTaskTemplateDir() + File.separator + resources.get(0).getResourceUrl();
        log.info("模板文件路径【{}】", templateUrl);

        String outputFilePathDir = getOutputFileDir(mrtonProcInfo);
        log.info("生成文档路径【{}】",outputFilePathDir);

        String outputFileName = "sys_" + System.currentTimeMillis() + ".docx";
        String outputFilePath = outputFilePathDir + File.separator + outputFileName;

        wordToolService.renderDocument(templateUrl, dataMap, outputFilePath);

        //先删除
        MrtonWordItemExample mrtonWordItemExample = new MrtonWordItemExample();
        mrtonWordItemExample.or().andProcIdEqualTo(taskId);
        mrtonWordItemMapper.deleteByExample(mrtonWordItemExample);

        MrtonResourceExample mrtonResourceExample = new MrtonResourceExample();
        mrtonResourceExample.or().andProcIdEqualTo(taskId);
        mrtonResourceMapper.deleteByExample(mrtonResourceExample);


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

        String dir = outputFilePathDir.replaceAll(systemConfig.getTaskDocDir(), "");
        resource.setResourceUrl( dir + File.separator + outputFileName);
        mrtonResourceService.insertMrtonResource(resource);

        return officeToolService.getLink(String.valueOf(resource.getId()), 1, MrtonConstants.OFFICE_PREVIEW_KEY);
    }

    /**
     * 文档存放路径
     * 文档存放路径规则 赛事名称/任务名称/sys_1588927934402.docx
     */
    private String getOutputFileDir(MrtonProcInfo mrtonProcInfo) {

        String marathonId = mrtonProcInfo.getMarathonId();

        MarathonInfo marathonInfo = marathonInfoService.selectMarathon_infoById(marathonId);
        String marathonName = marathonInfo.getMarathon_name();

        MrtonProcCfg mrtonProcCfg = mrtonProcCfgMapper.selectByPrimaryKey(mrtonProcInfo.getProcId());
        String taskName = mrtonProcCfg.getProcName();

        String outputFileDir = systemConfig.getTaskDocDir() + marathonName + File.separator + taskName;
        if (!new File(outputFileDir).exists()) {
            new File(outputFileDir).mkdirs();
        }
        return outputFileDir;
    }
}

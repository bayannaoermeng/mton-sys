package com.marathon.service.office.impl;

import com.google.common.collect.Maps;
import com.marathon.MrtonConstants;
import com.marathon.config.SystemConfig;
import com.marathon.domain.*;
import com.marathon.mapper.MrtonProcCfgMapper;
import com.marathon.mapper.MrtonProcCfgResourceMapper;
import com.marathon.mapper.MrtonResourceMapper;
import com.marathon.mapper.MrtonWordItemMapper;
import com.marathon.mapper.customize.MrtonResourceCustomizeMapper;
import com.marathon.qvo.ceremony.CommonPlan;
import com.marathon.qvo.ceremony.CommonPreviewDataVO;
import com.marathon.qvo.ceremony.CommonWordPlanVO;
import com.marathon.qvo.ceremony.PreviewData;
import com.marathon.service.IMarathonInfoService;
import com.marathon.service.IMrtonProcInfoService;
import com.marathon.service.IMrtonResourceService;
import com.marathon.service.office.Word2PdfService;
import com.marathon.service.office.WordTaskService;
import com.marathon.service.office.WordToolService;
import com.marathon.service.worditem.WordItemService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
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
    private WordItemService wordItemService;

    @Autowired
    private MrtonWordItemMapper mrtonWordItemMapper;

    @Autowired
    private IMrtonResourceService mrtonResourceService;

    @Autowired
    private MrtonResourceMapper mrtonResourceMapper;

    @Autowired
    private MrtonResourceCustomizeMapper mrtonResourceCustomizeMapper;

    @Autowired
    private SystemConfig systemConfig;


    /**
     * 返回任务（word模板任务）预览地址，没有生成文件的返回模板预览地址
     *
     * @param mrtonprocId
     * @return
     */
    @Override
    public String getPreviewFileName(String mrtonprocId) {
        MrtonResourceExample example = new MrtonResourceExample();
        example.or().andProcIdEqualTo(mrtonprocId);
        List<MrtonResource> lstResource = mrtonResourceMapper.selectByExample(example);
        //默认一个word任务只有一个对应文档资源
        if (lstResource.size() == 1) {
            //生成过文档
            MrtonResource resource = lstResource.get(0);
            String url = resource.getResourceUrl();
            String fileName = new File(systemConfig.getTaskDocDir() + url).getName();
            fileName = fileName.replaceAll("docx", "pdf");
            if (new File(getContextPreviewDir() + fileName).exists()) {
                return fileName;
            } else {
                throw new IllegalArgumentException("预览文件【" + fileName + "】不存在！");
            }

        } else {
            //找模板预览文件，如果不存在就生成一份
            MrtonProcInfo procInfo = mrtonProcInfoService.selectMrtonProcInfoById(mrtonprocId);
            String procCfgId = procInfo.getProcId();
            MrtonProcCfgResourceExample cfgResourceExample = new MrtonProcCfgResourceExample();
            cfgResourceExample.or().andCfgProcIdEqualTo(procCfgId);
            List<MrtonProcCfgResource> lstCfgResource = mrtonProcCfgResourceMapper.selectByExample(cfgResourceExample);
            if (lstCfgResource.size() == 1) {
                String templateUrl = lstCfgResource.get(0).getResourceUrl();
                String templateFilePath = systemConfig.getTaskTemplateDir() + templateUrl;

                String fileName = new File(templateFilePath).getName();
                fileName = fileName.replaceAll("docx", "pdf");

                if (new File(getContextPreviewDir() + fileName).exists()) {
                    return fileName;
                } else {
                    //生成模板pdf
                    try {
                        Word2PdfService.convert(templateFilePath, getContextPreviewDir());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return fileName;
                }
            }

        }
        return null;
    }

    /**
     * 获取预览文件夹路径
     *
     * @return
     * @throws Exception
     */
    private String getContextPreviewDir() {
        try {
            File resourceDir = new File(ResourceUtils.getURL("classpath:static").getPath().replace("%20", " ").replace('/', '\\'));
            if (!resourceDir.exists()) {
                resourceDir = new File("");
            }
            //如果上传目录为/static/images/upload/，则可以如下获取：
            File previewDir = new File(resourceDir.getAbsolutePath(), MrtonConstants.PREVIEW_DIR_PATH);
            return previewDir.getAbsolutePath() + File.separator;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("获取context路径失败！");
    }


    /**
     * wordItem转化成bean
     *
     * @param mrtonprocId
     * @param bean
     */
    @Override
    public void getWordItemBean(String mrtonprocId, CommonWordPlanVO bean, Class kind) {
        List<MrtonWordItem> lstItem = wordItemService.getWordItem(mrtonprocId);
        try {
            CommonPlan object = (CommonPlan) kind.newInstance();

            object.setId(mrtonprocId);

            if (lstItem.size() > 0) {

                Map<String, String> tmpMap = Maps.newHashMap();

                lstItem.forEach(item -> {
                    tmpMap.put(item.getPlaceholderKey(), item.getPlaceholderValue());
                });
                BeanUtils.populate(object, tmpMap);
            }

            bean.setBean(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 渲染word并且生成PDF预览，返回预览地址
     *
     * @param object
     * @param request
     * @return
     */
    @Override
    public String genWordAndPreview(Object object, HttpServletRequest request) {
        String previewUrl;
        try {
            Map<String, String> dataMap = BeanUtils.describe(object);

            String taskId = dataMap.remove("id");

            String fileName = genWordDoc(taskId, dataMap);

            previewUrl = request.getContextPath() + MrtonConstants.PREVIEW_DIR_PATH + fileName;

            log.info("文档预览地址【{}】", previewUrl);

        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        return previewUrl;
    }

    /**
     * 模板生成文档
     *
     * @param taskId
     */
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
        log.info("生成文档路径【{}】", outputFilePathDir);

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

        String dir = outputFilePathDir.replace(systemConfig.getTaskDocDir(), "");
        resource.setResourceUrl(dir + File.separator + outputFileName);
        mrtonResourceService.insertMrtonResource(resource);
        try {
            File resourceDir = new File(ResourceUtils.getURL("classpath:static").getPath().replace("%20", " ").replace('/', '\\'));
            if (!resourceDir.exists()) {
                resourceDir = new File("");
            }
            //如果上传目录为/static/images/upload/，则可以如下获取：
            File previewDir = new File(resourceDir.getAbsolutePath(), MrtonConstants.PREVIEW_DIR_PATH);
            if (!previewDir.exists()) {
                previewDir.mkdirs();
            }
            return Word2PdfService.convert(outputFilePath, previewDir.getAbsolutePath());
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
//        return officeToolService.getLink(String.valueOf(resource.getId()), 1, MrtonConstants.OFFICE_PREVIEW_KEY);
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

    /**
     * word任务历史参考文件列表
     *
     * @param wordTaskName
     * @return
     */
    @Override
    public CommonPreviewDataVO getRelatePreviewData(String wordTaskName) {

        CommonPreviewDataVO vo = new CommonPreviewDataVO();

        List<PreviewData> lstData = mrtonResourceCustomizeMapper.getRelatedResource(wordTaskName);

        if (lstData.size() > 0) {
            for (PreviewData data : lstData) {
                String fileName = new File(systemConfig.getTaskDocDir() + data.getUrl()).getName();
                fileName = fileName.replaceAll("docx", "pdf");
                if (!new File(getContextPreviewDir() + fileName).exists()) {
                    throw new IllegalArgumentException("预览文件【" + fileName + "】不存在！");
                }
                data.setUrl(fileName);
            }
            vo.setLstPreview(lstData);
        }
        return vo;
    }
}

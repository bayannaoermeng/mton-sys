package com.mton.web.controller.marathon.ceremony;

import com.google.common.collect.Maps;
import com.marathon.MrtonProcEnum;
import com.marathon.domain.MrtonWordItem;
import com.marathon.qvo.OrgChartDataVO;
import com.marathon.qvo.ceremony.AwardsPlan;
import com.marathon.qvo.ceremony.StartRunPlan;
import com.marathon.service.ceremony.ICeremonyService;
import com.marathon.service.office.WordTaskService;
import com.marathon.service.worditem.WordItemService;
import com.mton.common.base.AjaxResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author cuiguangqiang
 * @version CeremonyController, v0.1 2020/4/27 9:12
 * @description 仪式模块接口类
 */
@Slf4j
@Controller
@RequestMapping("/ceremony")
public class CeremonyController {
    private String prefix = "marathon/ceremony";

    @Autowired
    private ICeremonyService ceremonyService;

    @Autowired
    private WordItemService wordItemService;

    @Autowired
    private WordTaskService wordTaskService;

    @GetMapping("/init/{marathonId}")
    public String marathon_info(@PathVariable String marathonId, ModelMap modelMap) {
        modelMap.put("marathonId", marathonId);
        return prefix + "/index";
    }

    /**
     * 返回仪式结构图数据
     *
     * @return
     */
    @RequestMapping("/data/{mrtonId}")
    @ResponseBody
    public OrgChartDataVO getCeremonyData(@PathVariable String mrtonId) {

        return ceremonyService.getData(mrtonId, MrtonProcEnum.CEREMONY_PRO);

    }

    @GetMapping("/startrunplan/{mrtonprocId}")
    @ApiOperation(value = "起跑仪式方案")
    public String edit(@PathVariable("mrtonprocId") String mrtonprocId, ModelMap modelMap) {

        StartRunPlan startRunPlan = new StartRunPlan();

        startRunPlan.setId(mrtonprocId);

        getWordItemBean(mrtonprocId, startRunPlan);

        modelMap.put("startRunPlan", startRunPlan);
        return prefix + "/startrunplan";
    }

    @ApiOperation("保存起跑仪式方案")
    @PostMapping("savestartrunplan")
    @ResponseBody
    public AjaxResult saveStartRunPlan(StartRunPlan startRunPlan, HttpServletRequest request) {
        String previewUrl = genWordAndPreview(startRunPlan, request);

        return AjaxResult.success("操作成功", previewUrl);
    }

    @GetMapping("awardsplan/{mrtonprocId}")
    @ApiOperation(value = "颁奖仪式方案")
    public String awardsplan(@PathVariable("mrtonprocId") String mrtonprocId, ModelMap modelMap) {

        AwardsPlan awardsPlan = new AwardsPlan();

        awardsPlan.setId(mrtonprocId);

        getWordItemBean(mrtonprocId, awardsPlan);

        modelMap.put("awardPlan", awardsPlan);

        return prefix + "/awardplan";
    }

    @ApiOperation("保存起跑仪式方案")
    @PostMapping("saveawardsplan")
    @ResponseBody
    public AjaxResult saveAwardsPlan(AwardsPlan awardsPlan, HttpServletRequest request) {

        String previewUrl = genWordAndPreview(awardsPlan, request);

        return AjaxResult.success("操作成功", previewUrl);
    }

    /**
     * wordItem转化成bean
     *
     * @param mrtonprocId
     * @param bean
     */
    private void getWordItemBean(String mrtonprocId, Object bean) {
        List<MrtonWordItem> lstItem = wordItemService.getWordItem(mrtonprocId);

        if (lstItem.size() > 0) {

            Map<String, String> tmpMap = Maps.newHashMap();

            lstItem.forEach(item -> {
                tmpMap.put(item.getPlaceholderKey(), item.getPlaceholderValue());
            });

            try {
                BeanUtils.populate(bean, tmpMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 渲染word并且生成PDF预览，返回预览地址
     *
     * @param object
     * @param request
     * @return
     */
    private String genWordAndPreview(Object object, HttpServletRequest request) {
        String previewUrl;
        try {
            Map<String, String> dataMap = BeanUtils.describe(object);

            String taskId = dataMap.remove("id");

            String fileName = wordTaskService.genWordDoc(taskId, dataMap);

            previewUrl = request.getContextPath() + "/doc/preview/" + fileName;

            log.info("文档预览地址【{}】", previewUrl);

        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        return previewUrl;
    }
}

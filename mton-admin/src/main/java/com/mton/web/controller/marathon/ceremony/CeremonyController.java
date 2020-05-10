package com.mton.web.controller.marathon.ceremony;

import com.google.common.collect.Maps;
import com.marathon.MrtonProcEnum;
import com.marathon.domain.MrtonWordItem;
import com.marathon.qvo.OrgChartDataVO;
import com.marathon.qvo.ceremony.StartRunPlan;
import com.marathon.service.ceremony.ICeremonyService;
import com.marathon.service.office.WordTaskService;
import com.marathon.service.worditem.WordItemService;
import com.mton.common.base.AjaxResult;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author cuiguangqiang
 * @version CeremonyController, v0.1 2020/4/27 9:12
 * @description 仪式模块接口类
 */
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

        List<MrtonWordItem> lstItem = wordItemService.getWordItem(mrtonprocId);

        if(lstItem.size() > 0){

            Map<String,String> tmpMap = Maps.newHashMap();

            lstItem.forEach(item->{
                tmpMap.put(item.getPlaceholderKey(),item.getPlaceholderValue());
            });

            try {
                BeanUtils.populate(startRunPlan,tmpMap);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        modelMap.put("startRunPlan", startRunPlan);
        return prefix + "/startrunplan";
    }

    @ApiOperation("保存起跑仪式方案")
    @PostMapping("savestartrunplan")
    @ResponseBody
    public AjaxResult saveStartRunPlan(StartRunPlan startRunPlan){
        try {
           Map<String,String> dataMap = BeanUtils.describe(startRunPlan);

           String taskId = dataMap.remove("id");

           wordTaskService.genWordDoc(taskId,dataMap);

        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

        return AjaxResult.success();
    }
}

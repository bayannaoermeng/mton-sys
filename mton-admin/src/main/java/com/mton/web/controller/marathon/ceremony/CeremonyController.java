package com.mton.web.controller.marathon.ceremony;

import com.google.common.collect.Maps;
import com.marathon.MrtonProcEnum;
import com.marathon.domain.MrtonWordItem;
import com.marathon.qvo.OrgChartDataVO;
import com.marathon.qvo.ceremony.StartRunPlan;
import com.marathon.service.ceremony.ICeremonyService;
import com.marathon.service.worditem.WordItemService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author cuiguangqiang
 * @version CeremonyController, v0.1 2020/4/27 9:12
 * @description 类说明
 */
@Controller
@RequestMapping("/ceremony")
public class CeremonyController {
    private String prefix = "marathon/ceremony";

    @Autowired
    private ICeremonyService ceremonyService;

    @Autowired
    private WordItemService wordItemService;

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

    @GetMapping("/edit/{mrtonprocId}")
    @ApiOperation(value = "起跑仪式方案")
    public String edit(@PathVariable("mrtonprocId") String mrtonprocId, ModelMap modelMap) {
        List<MrtonWordItem> lstItem = wordItemService.getWordItem(mrtonprocId);

        if(lstItem.size() > 0){

            Map<String,String> tmpMap = Maps.newHashMap();

            lstItem.forEach(item->{
                tmpMap.put(item.getPlaceholderKey(),item.getPlaceholderValue());
            });

            StartRunPlan startRunPlan = new StartRunPlan();

            try {
                BeanUtils.populate(startRunPlan,tmpMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
            modelMap.put("startRunPlan", startRunPlan);
        }

        return prefix + "/startrunplan";
    }
}

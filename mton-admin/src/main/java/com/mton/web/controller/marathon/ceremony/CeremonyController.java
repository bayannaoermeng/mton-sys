package com.mton.web.controller.marathon.ceremony;

import com.marathon.MrtonProcEnum;
import com.marathon.qvo.OrgChartDataVO;
import com.marathon.service.ceremony.ICeremonyService;
import com.marathon.service.office.WordTaskService;
import com.marathon.service.worditem.WordItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}

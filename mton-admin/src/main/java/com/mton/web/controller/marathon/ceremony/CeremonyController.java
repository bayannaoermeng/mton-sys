package com.mton.web.controller.marathon.ceremony;

import com.marathon.MrtonProcEnum;
import com.marathon.qvo.OrgChartDataVO;
import com.marathon.service.ceremony.ICeremonyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("/init")
    public String marathon_info() {
        return prefix + "/index";
    }

    /**
     * 返回仪式结构图数据
     * @return
     */
    @RequestMapping("/data")
    @ResponseBody
    public OrgChartDataVO getCeremonyData() {

        return  ceremonyService.getData(MrtonProcEnum.CEREMONY_PRO);

    }
}

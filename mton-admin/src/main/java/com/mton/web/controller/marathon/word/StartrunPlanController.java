package com.mton.web.controller.marathon.word;

import com.marathon.MrtonConstants;
import com.marathon.qvo.ceremony.CommonWordPlanVO;
import com.marathon.qvo.ceremony.StartRunPlan;
import com.marathon.service.office.WordTaskService;
import com.mton.common.base.AjaxResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cuiguangqiang
 * @version StartrunPlanController, v0.1 2020/5/18 15:43
 * @description 起跑仪式方案
 */
@Controller
@RequestMapping("startrunplan")
public class StartrunPlanController {

    private String prefix = "marathon/ceremony";

    @Autowired
    private WordTaskService wordTaskService;

    @GetMapping("/edit/{mrtonprocId}")
    @ApiOperation(value = "起跑仪式方案")
    public String edit(@PathVariable("mrtonprocId") String mrtonprocId, ModelMap modelMap, HttpServletRequest request) {

        CommonWordPlanVO<StartRunPlan> bean = new CommonWordPlanVO<>();

        wordTaskService.getWordItemBean(mrtonprocId, bean, StartRunPlan.class);

        String previewFileName = wordTaskService.getPreviewFileName(mrtonprocId);

        bean.setPreviewUrl(request.getContextPath() + MrtonConstants.PREVIEW_DIR_PATH + previewFileName);

        //详细信息
        modelMap.put("bean", bean.getBean());
        modelMap.put("previewUrl", bean.getPreviewUrl());

        return prefix + "/startrunplan";
    }

    @ApiOperation("保存起跑仪式方案")
    @PostMapping("save")
    @ResponseBody
    public AjaxResult saveStartRunPlan(StartRunPlan startRunPlan, HttpServletRequest request) {

        String previewUrl = wordTaskService.genWordAndPreview(startRunPlan, request);

        return AjaxResult.success("操作成功", previewUrl);
    }

    @ApiOperation("参考文件列表")
    @GetMapping("relate")
    public AjaxResult<CommonWordPlanVO<String>> relate() {
        return  wordTaskService.getRelate();
        return AjaxResult.success();
    }

}

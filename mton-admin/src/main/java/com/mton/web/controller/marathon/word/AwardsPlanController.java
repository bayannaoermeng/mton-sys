package com.mton.web.controller.marathon.word;

import com.marathon.MrtonConstants;
import com.marathon.qvo.ceremony.AwardsPlan;
import com.marathon.qvo.ceremony.CommonWordPlanVO;
import com.marathon.service.office.WordTaskService;
import com.mton.common.base.AjaxResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cuiguangqiang
 * @version AwardsPlanController, v0.1 2020/5/18 15:56
 * @description 类说明
 */
@RequestMapping("awardsplan")
public class AwardsPlanController {

    private String prefix = "marathon/ceremony";

    @Autowired
    private WordTaskService wordTaskService;

    @GetMapping("edit/{mrtonprocId}")
    @ApiOperation(value = "颁奖仪式方案")
    public String awardsplan(@PathVariable("mrtonprocId") String mrtonprocId, ModelMap modelMap, HttpServletRequest request) {

        CommonWordPlanVO<AwardsPlan> bean = new CommonWordPlanVO<>();

        wordTaskService.getWordItemBean(mrtonprocId, bean, AwardsPlan.class);

        String previewFileName = wordTaskService.getPreviewFileName(mrtonprocId);

        bean.setPreviewUrl(request.getContextPath() + MrtonConstants.PREVIEW_DIR_PATH + previewFileName);

        modelMap.put("bean", bean.getBean());
        modelMap.put("previewUrl",bean.getPreviewUrl());

        return prefix + "/awardplan";
    }

    @ApiOperation("保存起跑仪式方案")
    @PostMapping("save")
    @ResponseBody
    public AjaxResult saveAwardsPlan(AwardsPlan awardsPlan, HttpServletRequest request) {

        String previewUrl = wordTaskService.genWordAndPreview(awardsPlan, request);

        return AjaxResult.success("操作成功", previewUrl);
    }




}

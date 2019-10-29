package com.ruoyi.web.controller.marathon;

import com.marathon.domain.MrtonSafetyGrasp;
import com.marathon.service.IMrtonSafetyGraspService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.web.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 安保-了解赛事，确定赛事规模 信息操作处理
 *
 * @author cuigq
 * @date 2019-10-29
 */
@Controller
@RequestMapping("/marathon/mrtonSafetyGrasp")
public class MrtonSafetyGraspController extends BaseController {

    @Autowired
    private IMrtonSafetyGraspService mrtonSafetyGraspService;


    /**
     * 修改保存安保-了解赛事，确定赛事规模
     */
    @RequiresPermissions("marathon:mrtonSafetyGrasp:edit")
    @Log(title = "安保-了解赛事，确定赛事规模" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MrtonSafetyGrasp mrtonSafetyGrasp) {
        return toAjax(mrtonSafetyGraspService.updateMrtonSafetyGrasp(mrtonSafetyGrasp));
    }
}

package com.mton.web.controller.marathon.workflow;

import com.mton.common.base.AjaxResult;
import com.mton.framework.web.base.BaseController;
import com.mton.system.domain.SysUser;
import com.mton.system.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cuiguangqiang
 * @version WorkflowApprovalController, v0.1 2020/6/10 8:33
 * @description 流程审批
 */
@RequestMapping("/approval")
@Controller
public class WorkflowApprovalController extends BaseController {

    @Autowired
    private ISysRoleService sysRoleService;


    /**
     * 审批列表
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public AjaxResult list(){

        SysUser sysUser = super.getSysUser();



        return AjaxResult.success();
    }


}

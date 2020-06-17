package com.mton.web.controller.marathon.workflow;

import com.marathon.domain.beans.WorkFlowApproveListBean;
import com.marathon.service.workflow.IWorkFlowService;
import com.marathon.service.workflow.WorkFlowEnum;
import com.mton.common.page.TableDataInfo;
import com.mton.framework.web.base.BaseController;
import com.mton.system.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author cuiguangqiang
 * @version WorkflowApprovalController, v0.1 2020/6/10 8:33
 * @description 流程审批
 */
@RequestMapping("/approval")
@Controller
public class WorkflowApprovalController extends BaseController {

    private String prefix = "marathon/workflow";

    @Autowired
    private IWorkFlowService workFlowService;

    @GetMapping("init")
    public String init() {
        return prefix + "/approve";
    }

    /**
     * 审批列表
     *
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public TableDataInfo list() {
        SysUser sysUser = super.getSysUser();
        startPage();
        List<WorkFlowApproveListBean> list = workFlowService.getMyApproveList(sysUser.getUserId(), WorkFlowEnum.WORK_FLOW_ANCHOR);
        return getDataTable(list);
    }
}

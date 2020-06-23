package com.mton.web.controller.marathon.workflow;

import com.marathon.domain.beans.WorkFlowApproveListBean;
import com.marathon.qvo.WorkflowApproveQO;
import com.marathon.qvo.ceremony.Mrton3PartyStaffVO;
import com.marathon.service.thirdpartystaff.IMrton3PartyStaffService;
import com.marathon.service.workflow.IWorkFlowService;
import com.marathon.service.workflow.WorkFlowEnum;
import com.mton.common.base.AjaxResult;
import com.mton.common.page.TableDataInfo;
import com.mton.framework.web.base.BaseController;
import com.mton.system.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private IMrton3PartyStaffService staffService;

    @GetMapping("init")
    public String init() {
        return prefix + "/approvelist";
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

    /**
     * 审批界面初始化
     * @param procId
     * @param modelMap
     * @return
     */
    @RequestMapping("approve/{procId}")
    public String approve(@PathVariable String procId, ModelMap modelMap){
        List<Mrton3PartyStaffVO> list = staffService.selectByProcId(procId);
        modelMap.put("lstStaff",list);
        return prefix + "/approve";
    }

    /**
     * 审批提交
     * @param approveQO
     * @return
     */
    @RequestMapping("approveaction")
    @ResponseBody
    public AjaxResult approveAction(WorkflowApproveQO approveQO){

        SysUser user = getSysUser();

        workFlowService.approve(approveQO,user);

        return AjaxResult.success();
    }
}

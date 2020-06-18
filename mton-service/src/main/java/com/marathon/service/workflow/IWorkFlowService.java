package com.marathon.service.workflow;

import com.marathon.domain.beans.WorkFlowApproveListBean;
import com.marathon.qvo.WorkflowApproveQO;
import com.mton.system.domain.SysUser;

import java.util.List;

public interface IWorkFlowService {

    /**
     * 查询用户待审核列表
     *
     * @param userId
     * @param workFlowAnchor
     * @return
     */
    List<WorkFlowApproveListBean> getMyApproveList(Long userId, WorkFlowEnum workFlowAnchor);


    /**
     * 审批操作
     * @param approveQO 审批结果
     * @param user 操作人
     */
    void approve(WorkflowApproveQO approveQO, SysUser user);
}

package com.marathon.service.workflow;

import com.marathon.domain.beans.WorkFlowApproveListBean;

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


}

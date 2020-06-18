package com.marathon.service.workflow.impl;

import com.marathon.domain.beans.WorkFlowApproveListBean;
import com.marathon.mapper.MrtonProcWorkflowMapper;
import com.marathon.qvo.WorkflowApproveQO;
import com.marathon.service.workflow.IWorkFlowService;
import com.marathon.service.workflow.WorkFlowEnum;
import com.mton.system.domain.SysUser;
import com.mton.system.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cuiguangqiang
 * @version WorkFlowServiceImpl, v0.1 2020/6/15 8:00
 * @description 类说明
 */
@Service
public class WorkFlowServiceImpl implements IWorkFlowService {

    @Autowired
    private MrtonProcWorkflowMapper mrtonProcWorkflowMapper;

    @Override
    public List<WorkFlowApproveListBean> getMyApproveList(Long userId, WorkFlowEnum flowEnum) {

        List<WorkFlowApproveListBean> lstApproveList = mrtonProcWorkflowMapper.getMyApproveList(userId,flowEnum.getCode());

        return lstApproveList;
    }

    @Override
    public void approve(WorkflowApproveQO approveQO, SysUser user) {



    }
}

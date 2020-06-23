package com.marathon.service.workflow.impl;

import com.marathon.domain.MrtonProcWorkflow;
import com.marathon.domain.MrtonProcWorkflowExample;
import com.marathon.domain.WorkflowBusiness;
import com.marathon.domain.beans.WorkFlowApproveListBean;
import com.marathon.domain.workflow.WorkflowLink;
import com.marathon.domain.workflow.WorkflowLinkExample;
import com.marathon.mapper.MrtonProcWorkflowMapper;
import com.marathon.mapper.WorkflowBusinessMapper;
import com.marathon.mapper.WorkflowLinkMapper;
import com.marathon.qvo.WorkflowApproveQO;
import com.marathon.service.workflow.IWorkFlowService;
import com.marathon.service.workflow.WorkFlowEnum;
import com.mton.system.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private WorkflowLinkMapper linkMapper;

    @Autowired
    private MrtonProcWorkflowMapper procWorkflowMapper;

    @Autowired
    private WorkflowBusinessMapper businessMapper;

    @Override
    public List<WorkFlowApproveListBean> getMyApproveList(Long userId, WorkFlowEnum flowEnum) {

        List<WorkFlowApproveListBean> lstApproveList = mrtonProcWorkflowMapper.getMyApproveList(userId, flowEnum.getCode());

        return lstApproveList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void approve(WorkflowApproveQO approveQO, SysUser user) {
        String procId = approveQO.getProcId();
        //查询当前节点
        MrtonProcWorkflowExample example = new MrtonProcWorkflowExample();
        example.or().andProcIdEqualTo(procId);
        example.setOrderByClause("node_id DESC");
        example.setLimitStart(0);
        example.setLimitEnd(1);
        List<MrtonProcWorkflow> lstWorkflow = procWorkflowMapper.selectByExample(example);
        if (lstWorkflow.size() == 1) {
            //当前流程节点ID
            Integer nodeId = lstWorkflow.get(0).getNodeId();

            //所有的当前节点的走向
            WorkflowLinkExample linkExample = new WorkflowLinkExample();
            linkExample.or().andWorkflowIdEqualTo(WorkFlowEnum.WORK_FLOW_ANCHOR.getCode()).andWorkflowLinkPrenodeEqualTo(nodeId);
            List<WorkflowLink> lstLink = linkMapper.selectByExample(linkExample);
            Integer approveResult = approveQO.getApproveResult();
            WorkflowLink linkk = null;
            if (1 == approveResult) {
                //审批通过
                for (WorkflowLink link : lstLink) {
                    if ("赛事总监通过候选人申请".equals(link.getWorkflowLinkName())) {
                        linkk = link;
                    }
                }
            } else {
                //审批拒绝
                for (WorkflowLink link : lstLink) {
                    if ("赛事总监拒绝候选人申请".equals(link.getWorkflowLinkName())) {
                        linkk = link;
                    }
                }
            }

            //插入流程业务表
            WorkflowBusiness business = new WorkflowBusiness();
            business.setBusinessId(procId);
            business.setNodeId(nodeId);
            business.setSuggestion(linkk.getWorkflowLinkName() + " " + approveQO.getRemark());
            business.setApprover(Math.toIntExact(user.getUserId()));
            business.setWorkflowId(WorkFlowEnum.WORK_FLOW_ANCHOR.getCode());
            businessMapper.insertSelective(business);

            //插入待处理流程
            MrtonProcWorkflowExample example1 = new MrtonProcWorkflowExample();
            example1.or().andProcIdEqualTo(procId);

            MrtonProcWorkflow procWorkflow = new MrtonProcWorkflow();
            procWorkflow.setNodeId(linkk.getWorkflowLinkNextnode());
            procWorkflow.setProcId(procId);
            procWorkflow.setWorkflowId(WorkFlowEnum.WORK_FLOW_ANCHOR.getCode());
            mrtonProcWorkflowMapper.updateByExampleSelective(procWorkflow,example1);
        }
    }
}

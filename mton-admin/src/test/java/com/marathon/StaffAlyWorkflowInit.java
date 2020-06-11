package com.marathon;

import com.marathon.domain.workflow.Workflow;
import com.marathon.domain.workflow.WorkflowApprover;
import com.marathon.domain.workflow.WorkflowLink;
import com.marathon.domain.workflow.WorkflowNode;
import com.marathon.mapper.*;
import com.mton.MrtonApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author cuiguangqiang
 * @version StaffAlyWorkflowInit, v0.1 2020/6/8 9:00
 * @description 初始化人员申请审批流程
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MrtonApplication.class)
public class StaffAlyWorkflowInit {

    @Autowired
    private WorkflowMapper workflowMapper;

    @Autowired
    private WorkflowNodeMapper workflowNodeMapper;

    @Autowired
    private WorkflowLinkMapper workflowLinkMapper;

    @Autowired
    private WorkflowApproverMapper workflowApproverMapper;

    @Autowired
    private WorkflowBusinessMapper workflowBusinessMapper;

    @Test
    public void init(){

        //定义流程
        Workflow workflow = new Workflow();
        workflow.setWorkflowName("主持人需求审批流程");
        workflow.setWorkflowDesc("用于主持人需求审批");
        workflowMapper.insert(workflow);

        //审批节点
        Integer workFlowId = workflow.getId();
        WorkflowNode node0 = new WorkflowNode();
        node0.setWorkflowId(workFlowId);
        node0.setNodeName("提交候选人申请");
        workflowNodeMapper.insert(node0);

        WorkflowNode node1 = new WorkflowNode();
        node1.setWorkflowId(workFlowId);
        node1.setNodeName("赛事总监确定候选人");
        workflowNodeMapper.insert(node1);

        WorkflowNode node2 = new WorkflowNode();
        node2.setWorkflowId(workFlowId);
        node2.setNodeName("提交合同");
        workflowNodeMapper.insert(node2);

        WorkflowNode node3 = new WorkflowNode();
        node3.setWorkflowId(workFlowId);
        node3.setNodeName("赛事总监审批合同");
        workflowNodeMapper.insert(node3);

        WorkflowNode node4 = new WorkflowNode();
        node4.setWorkflowId(workFlowId);
        node4.setNodeName("财物总监审批合同");
        workflowNodeMapper.insert(node4);

        WorkflowNode node5 = new WorkflowNode();
        node5.setWorkflowId(workFlowId);
        node5.setNodeName("结束");
        workflowNodeMapper.insert(node5);

        //节点对应责任人
        WorkflowApprover approver0 = new WorkflowApprover();
        approver0.setWorkflowId(workFlowId);
        approver0.setNodeId(node0.getId());
        approver0.setRoleId(1);
        workflowApproverMapper.insert(approver0);

        WorkflowApprover approver1 = new WorkflowApprover();
        approver1.setWorkflowId(workFlowId);
        approver1.setNodeId(node1.getId());
        approver1.setRoleId(1);
        workflowApproverMapper.insert(approver1);

        WorkflowApprover approver2 = new WorkflowApprover();
        approver2.setWorkflowId(workFlowId);
        approver2.setNodeId(node2.getId());
        approver2.setRoleId(1);
        workflowApproverMapper.insert(approver2);

        WorkflowApprover approver3 = new WorkflowApprover();
        approver3.setWorkflowId(workFlowId);
        approver3.setNodeId(node3.getId());
        approver3.setRoleId(1);
        workflowApproverMapper.insert(approver3);

        WorkflowApprover approver4 = new WorkflowApprover();
        approver4.setWorkflowId(workFlowId);
        approver4.setNodeId(node4.getId());
        approver4.setRoleId(1);
        workflowApproverMapper.insert(approver4);

        //link
        WorkflowLink link0 = new WorkflowLink();
        link0.setWorkflowId(workFlowId);
        link0.setWorkflowLinkPrenode(node0.getId());
        link0.setWorkflowLinkNextnode(node1.getId());
        link0.setWorkflowLinkName("提交候选人申请");
        workflowLinkMapper.insert(link0);

        WorkflowLink link1 = new WorkflowLink();
        link1.setWorkflowId(workFlowId);
        link1.setWorkflowLinkPrenode(node1.getId());
        link1.setWorkflowLinkNextnode(node2.getId());
        link1.setWorkflowLinkName("赛事总监通过候选人申请");
        workflowLinkMapper.insert(link1);

        WorkflowLink link2 = new WorkflowLink();
        link2.setWorkflowId(workFlowId);
        link2.setWorkflowLinkPrenode(node2.getId());
        link2.setWorkflowLinkNextnode(node3.getId());
        link2.setWorkflowLinkName("提交合同审批申请");
        workflowLinkMapper.insert(link2);

        WorkflowLink link3 = new WorkflowLink();
        link3.setWorkflowId(workFlowId);
        link3.setWorkflowLinkPrenode(node3.getId());
        link3.setWorkflowLinkNextnode(node4.getId());
        link3.setWorkflowLinkName("赛事总监通过合同申请");
        workflowLinkMapper.insert(link3);

        WorkflowLink link4 = new WorkflowLink();
        link4.setWorkflowId(workFlowId);
        link4.setWorkflowLinkPrenode(node4.getId());
        link4.setWorkflowLinkNextnode(node5.getId());
        link4.setWorkflowLinkName("财物总监通过合同申请");
        workflowLinkMapper.insert(link4);

        WorkflowLink link5 = new WorkflowLink();
        link5.setWorkflowId(workFlowId);
        link5.setWorkflowLinkPrenode(node1.getId());
        link5.setWorkflowLinkNextnode(node0.getId());
        link5.setWorkflowLinkName("赛事总监拒绝候选人申请");
        workflowLinkMapper.insert(link5);

        WorkflowLink link6 = new WorkflowLink();
        link6.setWorkflowId(workFlowId);
        link6.setWorkflowLinkPrenode(node3.getId());
        link6.setWorkflowLinkNextnode(node2.getId());
        link6.setWorkflowLinkName("赛事总监拒绝合同申请");
        workflowLinkMapper.insert(link6);

        WorkflowLink link7 = new WorkflowLink();
        link7.setWorkflowId(workFlowId);
        link7.setWorkflowLinkPrenode(node4.getId());
        link7.setWorkflowLinkNextnode(node2.getId());
        link7.setWorkflowLinkName("财物总监拒绝合同申请");
        workflowLinkMapper.insert(link7);

    }
}

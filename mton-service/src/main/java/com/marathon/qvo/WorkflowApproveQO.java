package com.marathon.qvo;

import lombok.Data;

/**
 * @author cuiguangqiang
 * @version WorkflowApproveQO, v0.1 2020/6/18 8:29
 * @description 审批提交数据结构
 */
@Data
public class WorkflowApproveQO {

    //任务ID
    private String procId;

    //审批结果（0:不同意 1:同意）
    private Integer approveResult;

    //审批意见
    private String remark;

}

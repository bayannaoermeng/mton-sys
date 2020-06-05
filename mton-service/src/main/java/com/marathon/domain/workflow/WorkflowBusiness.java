package com.marathon.domain.workflow;

import java.io.Serializable;
import java.util.Date;

public class WorkflowBusiness implements Serializable {
    /**
     * 流程节点id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * 流程id
     *
     * @mbggenerated
     */
    private Integer workflowId;

    /**
     * 业务id
     *
     * @mbggenerated
     */
    private Integer businessId;

    /**
     * 节点id
     *
     * @mbggenerated
     */
    private Integer nodeId;

    /**
     * 审批建议
     *
     * @mbggenerated
     */
    private String suggestion;

    /**
     * 审批人，关联user_id
     *
     * @mbggenerated
     */
    private Integer approver;

    /**
     * 删除标志（0代表存在 1代表删除）
     *
     * @mbggenerated
     */
    private Integer delFlag;

    /**
     * 创建者
     *
     * @mbggenerated
     */
    private Integer createBy;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新者
     *
     * @mbggenerated
     */
    private Integer updateBy;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(Integer workflowId) {
        this.workflowId = workflowId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion == null ? null : suggestion.trim();
    }

    public Integer getApprover() {
        return approver;
    }

    public void setApprover(Integer approver) {
        this.approver = approver;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
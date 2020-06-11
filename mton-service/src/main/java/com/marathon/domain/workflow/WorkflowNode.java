package com.marathon.domain.workflow;

import java.io.Serializable;
import java.util.Date;

public class WorkflowNode implements Serializable {
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
     * 节点名称
     *
     * @mbggenerated
     */
    private String nodeName;

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

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName == null ? null : nodeName.trim();
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
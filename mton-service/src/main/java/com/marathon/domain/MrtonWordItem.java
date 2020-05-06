package com.marathon.domain;

import java.io.Serializable;
import java.util.Date;

public class MrtonWordItem implements Serializable {
    private Integer id;

    /**
     * 任务ID
     *
     * @mbggenerated
     */
    private String procId;

    private String placeholderKey;

    private String placeholderValue;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProcId() {
        return procId;
    }

    public void setProcId(String procId) {
        this.procId = procId == null ? null : procId.trim();
    }

    public String getPlaceholderKey() {
        return placeholderKey;
    }

    public void setPlaceholderKey(String placeholderKey) {
        this.placeholderKey = placeholderKey == null ? null : placeholderKey.trim();
    }

    public String getPlaceholderValue() {
        return placeholderValue;
    }

    public void setPlaceholderValue(String placeholderValue) {
        this.placeholderValue = placeholderValue == null ? null : placeholderValue.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }
}
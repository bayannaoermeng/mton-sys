package com.marathon.domain;

import java.io.Serializable;

public class MrtonProcCfg implements Serializable {
    /**
     * 步骤ID
     *
     * @mbggenerated
     */
    private String procId;

    /**
     * 步骤名称
     *
     * @mbggenerated
     */
    private String procName;

    /**
     * 序号，排序使用
     *
     * @mbggenerated
     */
    private Integer procSeq;

    /**
     * 父步骤ID
     *
     * @mbggenerated
     */
    private String parentProcId;

    /**
     * 时间要对于比赛时间，true 之前，false 之后
     *
     * @mbggenerated
     */
    private Integer comparativelyToMrton;

    /**
     * 开始时间偏移量（天）
     *
     * @mbggenerated
     */
    private Integer starttimeOffset;

    /**
     * 结束时间偏移量
     *
     * @mbggenerated
     */
    private Integer endtimeOffset;

    /**
     * 工作内容
     *
     * @mbggenerated
     */
    private String procContent;

    /**
     * 工作描述说明
     *
     * @mbggenerated
     */
    private String procDescri;

    /**
     * 附件资源ID
     *
     * @mbggenerated
     */
    private String attachResourceId;

    /**
     * 状态，0正常，1禁用
     *
     * @mbggenerated
     */
    private Integer procStatus;

    /**
     * 预留字段
     *
     * @mbggenerated
     */
    private String reserved;

    /**
     * 是否被删除
     *
     * @mbggenerated
     */
    private Integer delFlag;

    private static final long serialVersionUID = 1L;

    public String getProcId() {
        return procId;
    }

    public void setProcId(String procId) {
        this.procId = procId == null ? null : procId.trim();
    }

    public String getProcName() {
        return procName;
    }

    public void setProcName(String procName) {
        this.procName = procName == null ? null : procName.trim();
    }

    public Integer getProcSeq() {
        return procSeq;
    }

    public void setProcSeq(Integer procSeq) {
        this.procSeq = procSeq;
    }

    public String getParentProcId() {
        return parentProcId;
    }

    public void setParentProcId(String parentProcId) {
        this.parentProcId = parentProcId == null ? null : parentProcId.trim();
    }

    public Integer getComparativelyToMrton() {
        return comparativelyToMrton;
    }

    public void setComparativelyToMrton(Integer comparativelyToMrton) {
        this.comparativelyToMrton = comparativelyToMrton;
    }

    public Integer getStarttimeOffset() {
        return starttimeOffset;
    }

    public void setStarttimeOffset(Integer starttimeOffset) {
        this.starttimeOffset = starttimeOffset;
    }

    public Integer getEndtimeOffset() {
        return endtimeOffset;
    }

    public void setEndtimeOffset(Integer endtimeOffset) {
        this.endtimeOffset = endtimeOffset;
    }

    public String getProcContent() {
        return procContent;
    }

    public void setProcContent(String procContent) {
        this.procContent = procContent == null ? null : procContent.trim();
    }

    public String getProcDescri() {
        return procDescri;
    }

    public void setProcDescri(String procDescri) {
        this.procDescri = procDescri == null ? null : procDescri.trim();
    }

    public String getAttachResourceId() {
        return attachResourceId;
    }

    public void setAttachResourceId(String attachResourceId) {
        this.attachResourceId = attachResourceId == null ? null : attachResourceId.trim();
    }

    public Integer getProcStatus() {
        return procStatus;
    }

    public void setProcStatus(Integer procStatus) {
        this.procStatus = procStatus;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved == null ? null : reserved.trim();
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}
package com.marathon.domain;

import com.mton.common.base.BaseEntity;

import java.io.Serializable;
import java.util.Date;

public class Mrton3PartyStaff extends BaseEntity implements Serializable {
    private Integer id;

    /**
     * 任务ID
     *
     * @mbggenerated
     */
    private String procId;

    /**
     * 是否被选中为供应商:0:备选,1:被选中
     *
     * @mbggenerated
     */
    private Integer master;

    /**
     * 供应商
     *
     * @mbggenerated
     */
    private String supplier;

    /**
     * 对接人
     *
     * @mbggenerated
     */
    private String contactPerson;

    /**
     * 联系方式
     *
     * @mbggenerated
     */
    private String mobile;

    /**
     * 报价
     *
     * @mbggenerated
     */
    private String price;

    /**
     * 交通食宿
     *
     * @mbggenerated
     */
    private String transportation;

    /**
     * 发票详情
     *
     * @mbggenerated
     */
    private String invoiceDetail;

    /**
     * 备注
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * 人员详情
     *
     * @mbggenerated
     */
    private String staffDetail;

    /**
     * 人员类型 0:主持人 1:礼仪 2:热身教练 3:演艺活动
     *
     * @mbggenerated
     */
    private Integer staffType;

    /**
     * 简历路径
     *
     * @mbggenerated
     */
    private String resumePath;

    /**
     * 删除标记 0：已删除  1：未删除
     *
     * @mbggenerated
     */
    private Integer delFlag;

    /**
     * 创建用户
     *
     * @mbggenerated
     */
    private String createUserName;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 创建用户
     *
     * @mbggenerated
     */
    private String updateUserName;

    private Date updateTime;

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

    public Integer getMaster() {
        return master;
    }

    public void setMaster(Integer master) {
        this.master = master;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson == null ? null : contactPerson.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getTransportation() {
        return transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation == null ? null : transportation.trim();
    }

    public String getInvoiceDetail() {
        return invoiceDetail;
    }

    public void setInvoiceDetail(String invoiceDetail) {
        this.invoiceDetail = invoiceDetail == null ? null : invoiceDetail.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getStaffDetail() {
        return staffDetail;
    }

    public void setStaffDetail(String staffDetail) {
        this.staffDetail = staffDetail == null ? null : staffDetail.trim();
    }

    public Integer getStaffType() {
        return staffType;
    }

    public void setStaffType(Integer staffType) {
        this.staffType = staffType;
    }

    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        this.resumePath = resumePath == null ? null : resumePath.trim();
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
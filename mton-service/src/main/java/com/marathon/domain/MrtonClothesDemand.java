package com.marathon.domain;

import java.io.Serializable;
import java.util.Date;

public class MrtonClothesDemand implements Serializable {
    /**
     * id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * 任务ID
     *
     * @mbggenerated
     */
    private String procId;

    /**
     * 姓名
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 性别 0:女 1:男
     *
     * @mbggenerated
     */
    private Integer gender;

    /**
     * 上装尺码
     *
     * @mbggenerated
     */
    private String shirtSize;

    /**
     * 下装尺码
     *
     * @mbggenerated
     */
    private String trousersSize;

    /**
     * 鞋子尺码
     *
     * @mbggenerated
     */
    private String shoesSize;

    /**
     * 备注
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * 类别 0:员工 1:嘉宾
     *
     * @mbggenerated
     */
    private Integer category;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getShirtSize() {
        return shirtSize;
    }

    public void setShirtSize(String shirtSize) {
        this.shirtSize = shirtSize == null ? null : shirtSize.trim();
    }

    public String getTrousersSize() {
        return trousersSize;
    }

    public void setTrousersSize(String trousersSize) {
        this.trousersSize = trousersSize == null ? null : trousersSize.trim();
    }

    public String getShoesSize() {
        return shoesSize;
    }

    public void setShoesSize(String shoesSize) {
        this.shoesSize = shoesSize == null ? null : shoesSize.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
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
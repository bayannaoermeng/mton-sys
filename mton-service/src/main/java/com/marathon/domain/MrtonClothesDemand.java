package com.marathon.domain;

import com.mton.common.base.BaseEntity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MrtonClothesDemand extends BaseEntity {
    /**
     * id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 任务ID
     *
     * @mbg.generated
     */
    private String procId;

    /**
     * 姓名
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 性别 1:女 0:男
     *
     * @mbg.generated
     */
    private Integer gender;

    /**
     * 上装尺码
     *
     * @mbg.generated
     */
    private String shirtSize;

    /**
     * 下装尺码
     *
     * @mbg.generated
     */
    private String trousersSize;

    /**
     * 鞋子尺码
     *
     * @mbg.generated
     */
    private String shoesSize;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String remark;

    /**
     * 类别 0:员工 1:嘉宾
     *
     * @mbg.generated
     */
    private Integer category;

    /**
     * 删除标记 0：已删除  1：未删除
     *
     * @mbg.generated
     */
    private Integer delFlag;

    /**
     * 创建用户
     *
     * @mbg.generated
     */
    private String createUserName;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private LocalDateTime createTime;

    /**
     * 创建用户
     *
     * @mbg.generated
     */
    private String updateUserName;

    private LocalDateTime updateTime;

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

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }
}
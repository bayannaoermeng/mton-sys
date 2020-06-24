package com.marathon.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MrtonFoodDemand implements Serializable {
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
     * 申请部门
     *
     * @mbg.generated
     */
    private String department;

    /**
     * 早中晚餐 0早 1:中餐 2:晚餐
     *
     * @mbg.generated
     */
    private Integer stage;

    /**
     * 餐饮标准
     *
     * @mbg.generated
     */
    private String foodStandard;

    /**
     * 具体要求
     *
     * @mbg.generated
     */
    private String requirement;

    /**
     * 餐饮数量
     *
     * @mbg.generated
     */
    private Integer foodCount;

    /**
     * 饮用水数量
     *
     * @mbg.generated
     */
    private Integer waterCount;

    /**
     * 送餐时间
     *
     * @mbg.generated
     */
    private LocalDateTime serviceTime;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String remark;

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public String getFoodStandard() {
        return foodStandard;
    }

    public void setFoodStandard(String foodStandard) {
        this.foodStandard = foodStandard == null ? null : foodStandard.trim();
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement == null ? null : requirement.trim();
    }

    public Integer getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(Integer foodCount) {
        this.foodCount = foodCount;
    }

    public Integer getWaterCount() {
        return waterCount;
    }

    public void setWaterCount(Integer waterCount) {
        this.waterCount = waterCount;
    }

    public LocalDateTime getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(LocalDateTime serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
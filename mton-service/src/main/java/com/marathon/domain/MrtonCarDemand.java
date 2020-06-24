package com.marathon.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MrtonCarDemand implements Serializable {
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
     * 用车时间
     *
     * @mbg.generated
     */
    private LocalDateTime serviceTime;

    /**
     * 用车数量
     *
     * @mbg.generated
     */
    private Integer carCount;

    /**
     * 乘坐人数量
     *
     * @mbg.generated
     */
    private Integer riderCount;

    /**
     * 车型
     *
     * @mbg.generated
     */
    private String carModel;

    /**
     * 路线
     *
     * @mbg.generated
     */
    private String route;

    /**
     * 用途
     *
     * @mbg.generated
     */
    private String carUse;

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

    public LocalDateTime getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(LocalDateTime serviceTime) {
        this.serviceTime = serviceTime;
    }

    public Integer getCarCount() {
        return carCount;
    }

    public void setCarCount(Integer carCount) {
        this.carCount = carCount;
    }

    public Integer getRiderCount() {
        return riderCount;
    }

    public void setRiderCount(Integer riderCount) {
        this.riderCount = riderCount;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel == null ? null : carModel.trim();
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route == null ? null : route.trim();
    }

    public String getCarUse() {
        return carUse;
    }

    public void setCarUse(String carUse) {
        this.carUse = carUse == null ? null : carUse.trim();
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
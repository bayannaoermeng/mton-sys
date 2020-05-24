package com.marathon.domain;

import java.io.Serializable;
import java.util.Date;

public class MrtonStageFlow implements Serializable {
    private Integer id;

    /**
     * 任务ID
     *
     * @mbggenerated
     */
    private String procId;

    /**
     * 开始时间
     *
     * @mbggenerated
     */
    private Date startTime;

    /**
     * 结束时间
     *
     * @mbggenerated
     */
    private Date endTime;

    /**
     * 区域
     *
     * @mbggenerated
     */
    private String region;

    /**
     * 事件
     *
     * @mbggenerated
     */
    private String event;

    /**
     * 详细描述
     *
     * @mbggenerated
     */
    private String description;

    /**
     * 负责人
     *
     * @mbggenerated
     */
    private String principal;

    /**
     * 相关人员
     *
     * @mbggenerated
     */
    private String otherPeople;

    /**
     * 音频
     *
     * @mbggenerated
     */
    private String audio;

    /**
     * 视频
     *
     * @mbggenerated
     */
    private String video;

    /**
     * 道具
     *
     * @mbggenerated
     */
    private String props;

    /**
     * 灯光
     *
     * @mbggenerated
     */
    private String light;

    /**
     * 备注
     *
     * @mbggenerated
     */
    private String remarks;

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

    public String getProcId() {
        return procId;
    }

    public void setProcId(String procId) {
        this.procId = procId == null ? null : procId.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event == null ? null : event.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal == null ? null : principal.trim();
    }

    public String getOtherPeople() {
        return otherPeople;
    }

    public void setOtherPeople(String otherPeople) {
        this.otherPeople = otherPeople == null ? null : otherPeople.trim();
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio == null ? null : audio.trim();
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video == null ? null : video.trim();
    }

    public String getProps() {
        return props;
    }

    public void setProps(String props) {
        this.props = props == null ? null : props.trim();
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light == null ? null : light.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
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
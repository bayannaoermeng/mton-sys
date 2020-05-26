package com.marathon.domain;

import lombok.Data;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Data
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
    private String startTime;

    /**
     * 结束时间
     *
     * @mbggenerated
     */
    private String endTime;

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

    /**
     * 时长
     */
    private String duration;

    private static final long serialVersionUID = 1L;

}
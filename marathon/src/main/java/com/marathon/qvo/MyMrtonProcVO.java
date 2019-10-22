package com.marathon.qvo;

import com.ruoyi.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author cuiguangqiang
 * @version MyMrtonProcVO, v0.1 2019/10/16 10:55
 * @description 我的赛事任务数据类型
 */
@ApiModel
@Data
public class MyMrtonProcVO extends BaseEntity {

    @ApiModelProperty(value = "唯一ID",name = "martonProcId")
    private String mrtonProcId;

    @ApiModelProperty(value="步骤名称",name="procName")
    private String procName;

    @ApiModelProperty(value="序号，排序使用",name="procSeq")
    private Integer procSeq;

    @ApiModelProperty(value="计划开始时间",name="planStarttime")
    private Date planStarttime;

    @ApiModelProperty(value="计划结束时间",name="planEndtime")
    private Date planEndtime;

    @ApiModelProperty(value = "实际开始时间")
    private Date realStarttime;

    @ApiModelProperty(value = "实际结束时间")
    private Date realEndtime;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "是否自定义任务")
    private Integer customize;

    @ApiModelProperty(value = "状态中文")
    private String statusStr;

}

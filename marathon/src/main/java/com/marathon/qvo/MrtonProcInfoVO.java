package com.marathon.qvo;

import com.ruoyi.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author cuiguangqiang
 * @version MrtonProcInfoVO, v0.1 2019/10/9 11:50
 * @description 任务分配信息
 */
@Data
public class MrtonProcInfoVO extends BaseEntity {
    @ApiModelProperty(value = "唯一ID",name = "martonProcId")
    private String mrtonProcId;

    @ApiModelProperty(value="步骤ID",name="procId")
    private String procId;

    @ApiModelProperty(value="步骤名称",name="procName")
    private String procName;

    @ApiModelProperty(value="序号，排序使用",name="procSeq")
    private Integer procSeq;

    @ApiModelProperty(value="父步骤ID",name="parentProcId")
    private String parentProcId;

    @ApiModelProperty(value="计划开始时间",name="planStarttime")
    private Date planStarttime;

    @ApiModelProperty(value="计划结束时间",name="planEndtime")
    private Date planEndtime;

    @ApiModelProperty(value = "责任人",name = "principals")
    private String principals;

}

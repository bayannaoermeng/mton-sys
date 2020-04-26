package com.marathon.qvo;

import com.mton.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author cuiguangqiang
 * @version MrtonProcInfoVO, v0.1 2019/10/9 11:50
 * @description 任务分配信息
 */
@Data
public class MrtonProcInfoVO extends BaseEntity {
    @ApiModelProperty(value = "赛事ID",name = "mrtonId")
    private String mrtonId;

    @ApiModelProperty(value="父步骤ID",name="parentProcId")
    private String parentProcId;


    @ApiModelProperty(value="步骤名称",name="procName")
    private String procName;

    @ApiModelProperty(value="序号，排序使用",name="procSeq")
    private Integer procSeq;

    @ApiModelProperty(value = "责任人",name = "principals")
    private String principals;

}

package com.marathon.qvo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author cuiguangqiang
 * @version MrtonProcCommonQVO, v0.1 2020/1/20 11:21
 * @description 赛事任务详细信息共用数据结构
 */
public class MrtonProcCommonQVO {

    @ApiModelProperty(value="主键ID",name="id")
    private String id;

    @ApiModelProperty(value="是否是自定义",name="customize")
    private Integer customize;

    @ApiModelProperty(value="customize = 1时有效，自定义过程名称",name="procName")
    private String procName;

    @ApiModelProperty(value="计划开始时间",name="planStarttime")
    private Date planStarttime;

    @ApiModelProperty(value="计划结束时间",name="planEndtime")
    private Date planEndtime;

    @ApiModelProperty(value="工作内容",name="procContent")
    private String procContent;

    @ApiModelProperty(value="工作描述说明",name="procDescri")
    private String procDescri;

    //TODO　资源列表


}

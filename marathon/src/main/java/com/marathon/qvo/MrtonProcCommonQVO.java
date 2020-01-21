package com.marathon.qvo;

import com.marathon.domain.MrtonProcCfgResource;
import com.mton.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author cuiguangqiang
 * @version MrtonProcCommonQVO, v0.1 2020/1/20 11:21
 * @description 赛事任务详细信息共用数据结构
 */
@Data
public class MrtonProcCommonQVO extends BaseEntity {

    @ApiModelProperty(value="主键ID",name="id")
    private String id;

    @ApiModelProperty(value = "配置任务ID",name = "procCfgId")
    private String procCfgId;

    @ApiModelProperty(value="是否是自定义",name="customize")
    private Integer customize;

    @ApiModelProperty(value="customize = 1时有效，自定义过程名称",name="procName")
    private String procName;

    @ApiModelProperty(value="计划开始时间",name="planStarttime")
    private Date planStarttime;

    private String planStarttimeStr;

    @ApiModelProperty(value="计划结束时间",name="planEndtime")
    private Date planEndtime;

    private String planEndtimeStr;

    @ApiModelProperty(value="工作内容",name="procContent")
    private String procContent;

    @ApiModelProperty(value="工作描述说明",name="procDescri")
    private String procDescri;

    @ApiModelProperty(value = "资源列表",name ="lstResource")
    private List<MrtonProcCfgResource> lstResource;

}

package com.marathon.qvo;

import com.mton.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author cuiguangqiang
 * @version MyMrtonProcQO, v0.1 2019/10/16 14:24
 * @description 我的赛事任务列表请求数据类型
 */

@Data
@ApiModel(value = "我的赛事任务列表请求数据")
public class MyMrtonProcQO extends BaseEntity {

    @ApiModelProperty(value = "赛事ID")
    private String marathonId;

    @ApiModelProperty(value = "过程序号，如12代表安保")
    private int procSequence;

}

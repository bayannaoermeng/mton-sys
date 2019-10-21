package com.marathon.qvo;

import com.ruoyi.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author cuiguangqiang
 * @version SaveProcPrincipalQO, v0.1 2019/10/14 18:10
 * @description 类说明
 */

@Data
@ApiModel(description="保存责任人",parent=BaseEntity.class)
public class SaveProcPrincipalQO extends BaseEntity {

    private String mrtonId;

    @ApiModelProperty()
    private String parentProcId;

    //userId逗号分隔
    @ApiModelProperty
    private String principals;
}

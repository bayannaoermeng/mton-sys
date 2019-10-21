package com.marathon.qvo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author cuiguangqiang
 * @version PrincipalBean, v0.1 2019/10/11 19:37
 * @description 类说明
 */
@Data
public class PrincipalBean {

    @ApiModelProperty("userId")
    private Long userId;
    @ApiModelProperty("userName")
    private String userName;
    @ApiModelProperty("是否被选中")
    private boolean checked;

}

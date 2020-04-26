package com.marathon.domain;

import com.mton.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

                        /**
 * 赛事任务人员关系表 mrton_proc_user
 *
 * @author null
 * @date 2019-10-17
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description="赛事任务人员关系",parent=BaseEntity.class)
public class MrtonProcUser extends BaseEntity{

    private static final long serialVersionUID=1L;
    
    @ApiModelProperty(value="",name="id")
    private Integer id;
        
    @ApiModelProperty(value="赛事ID",name="mrtonId")
    private String mrtonId;
        
    @ApiModelProperty(value="mrton_proc_cfg里的顶级任务ID",name="parentProcId")
    private String parentProcId;
        
    @ApiModelProperty(value="用户ID",name="userId")
    private Integer userId;
        
    @ApiModelProperty(value="职责",name="role")
    private String role;
        
    @ApiModelProperty(value="预留字段",name="reserve1")
    private String reserve1;
    
}

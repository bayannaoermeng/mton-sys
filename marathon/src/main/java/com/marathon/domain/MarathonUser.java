package com.marathon.domain;

import com.ruoyi.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 赛事人员分配表 marathon_user
 *
 * @author null
 * @date 2019-08-19
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description="赛事人员分配",parent=BaseEntity.class)
public class MarathonUser extends BaseEntity{

    private static final long serialVersionUID=1L;
    
    @ApiModelProperty(value="id主键",name="id")
    private String id;
        
    @ApiModelProperty(value="赛事ID",name="marathon_id")
    private String marathon_id;
        
    @ApiModelProperty(value="负责人ID",name="user_id")
    private Integer user_id;
        
    @ApiModelProperty(value="任务ID，预留",name="task_id")
    private String task_id;
    
}

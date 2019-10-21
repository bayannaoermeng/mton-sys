package com.marathon.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 赛事表 marathon_info
 *
 * @author null
 * @date 2019-08-17
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description="赛事",parent=BaseEntity.class)
public class MarathonInfo extends BaseEntity{

    private static final long serialVersionUID=1L;
    
    @ApiModelProperty(value="赛事ID",name="marathon_uuid")
    private String marathon_uuid;
        
    @ApiModelProperty(value="赛事名称",name="marathon_name")
    private String marathon_name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value="赛事开始时间",name="marathon_starttime")
    private Date marathon_starttime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value="赛事结束时间",name="marathon_endtime")
    private Date marathon_endtime;
        
    @ApiModelProperty(value="赛事举办详细地址",name="marathon_address")
    private String marathon_address;
        
    @ApiModelProperty(value="创建者",name="marathon_creater")
    private String marathon_creater;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="创建时间",name="marathon_createtime")
    private Date marathon_createtime;
        
    @ApiModelProperty(value="最后修改者",name="marathon_updater")
    private String marathon_updater;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="最后修改时间",name="marathon_updatetime")
    private Date marathon_updatetime;
        
    @ApiModelProperty(value="是否被删除",name="marathon_deleted")
    private Integer marathon_deleted;
    
}

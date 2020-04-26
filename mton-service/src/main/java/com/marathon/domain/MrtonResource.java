package com.marathon.domain;

import com.mton.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 任务关联资源（文件）表 mrton_resource
 *
 * @author cuigq
 * @date 2019-11-05
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description="任务关联资源（文件）",parent=BaseEntity.class)
public class MrtonResource extends BaseEntity{

    private static final long serialVersionUID=1L;
    
    @ApiModelProperty(value="",name="id")
    private Integer id;
        
    @ApiModelProperty(value="",name="procId")
    private String procId;
        
    @ApiModelProperty(value="文件名",name="resourceName")
    private String resourceName;
        
    @ApiModelProperty(value="",name="resourceUrl")
    private String resourceUrl;
        
    @ApiModelProperty(value="上传时间",name="createtime")
    private Date createtime;
        
    @ApiModelProperty(value="编辑者",name="uploader")
    private Integer uploader;
        
    @ApiModelProperty(value="是否是模板",name="isTemplate")
    private Integer isTemplate;
        
    @ApiModelProperty(value="是否被删除",name="delFlag")
    private Integer delFlag;
    
}

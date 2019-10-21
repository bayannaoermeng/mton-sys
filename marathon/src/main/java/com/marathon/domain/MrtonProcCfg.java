package com.marathon.domain;

import com.ruoyi.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

                                                    /**
 * 赛事分解过程(步骤)配置表 mrton_proc_cfg
 *
 * @author cuigq
 * @date 2019-10-08
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description="赛事分解过程(步骤)配置",parent=BaseEntity.class)
public class MrtonProcCfg extends BaseEntity{

    private static final long serialVersionUID=1L;
    
    @ApiModelProperty(value="步骤ID",name="procId")
    private String procId;
        
    @ApiModelProperty(value="步骤名称",name="procName")
    private String procName;
        
    @ApiModelProperty(value="序号，排序使用",name="procSeq")
    private Integer procSeq;
        
    @ApiModelProperty(value="父步骤ID",name="parentProcId")
    private String parentProcId;
        
    @ApiModelProperty(value="时间要对于比赛时间，true 之前，false 之后",name="comparativelyToMrton")
    private Integer comparativelyToMrton;
        
    @ApiModelProperty(value="开始时间偏移量（天）",name="starttimeOffset")
    private Integer starttimeOffset;
        
    @ApiModelProperty(value="结束时间偏移量",name="endtimeOffset")
    private Integer endtimeOffset;
        
    @ApiModelProperty(value="工作内容",name="procContent")
    private String procContent;
        
    @ApiModelProperty(value="工作描述说明",name="procDescri")
    private String procDescri;
        
    @ApiModelProperty(value="附件资源ID",name="attachResourceId")
    private String attachResourceId;
        
    @ApiModelProperty(value="状态，0正常，1禁用",name="procStatus")
    private Integer procStatus;
        
    @ApiModelProperty(value="预留字段",name="reserved")
    private String reserved;
        
    @ApiModelProperty(value="是否被删除",name="delFlag")
    private Integer delFlag;
    
}

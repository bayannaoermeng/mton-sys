package com.marathon.domain;


import com.mton.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

                                                import java.math.BigDecimal;
import java.util.Date;

/**
 * 赛事过程关系表 mrton_proc_info
 *
 * @author cgq
 * @date 2019-10-17
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description="赛事过程关系",parent=BaseEntity.class)
public class MrtonProcInfo extends BaseEntity{

    private static final long serialVersionUID=1L;
    
    @ApiModelProperty(value="主键ID",name="id")
    private String id;
        
    @ApiModelProperty(value="赛事ID",name="marathonId")
    private String marathonId;
        
    @ApiModelProperty(value="父过程ID（mrton_proc_cfg）",name="parentProcId")
    private String parentProcId;
        
    @ApiModelProperty(value="过程ID（mrton_proc_cfg）",name="procId")
    private String procId;
        
    @ApiModelProperty(value="是否是自定义",name="customize")
    private Integer customize;
        
    @ApiModelProperty(value="customize = 1时有效，自定义过程名称",name="procName")
    private String procName;
        
    @ApiModelProperty(value="计划开始时间",name="planStarttime")
    private Date planStarttime;
        
    @ApiModelProperty(value="计划结束时间",name="planEndtime")
    private Date planEndtime;
        
    @ApiModelProperty(value="实际开始时间",name="realStarttime")
    private Date realStarttime;
        
    @ApiModelProperty(value="实际结束时间",name="realEndtime")
    private Date realEndtime;
        
    @ApiModelProperty(value="产生费用（预留）",name="fee")
    private BigDecimal fee;
        
    @ApiModelProperty(value="状态，0新建 1进行中 2暂停 3终止 4结束",name="status")
    private Integer status;
        
    @ApiModelProperty(value=" 预留字段1",name="reserve1")
    private String reserve1;
        
    @ApiModelProperty(value=" 预留字段1",name="reserve2")
    private String reserve2;
        
    @ApiModelProperty(value=" 预留字段3",name="reserve3")
    private String reserve3;
    
}

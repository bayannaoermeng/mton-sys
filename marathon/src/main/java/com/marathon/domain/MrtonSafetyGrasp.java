package com.marathon.domain;

import com.mton.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

                    /**
 * 安保-了解赛事，确定赛事规模表 mrton_safety_grasp
 *
 * @author cuigq
 * @date 2019-10-29
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description="安保-了解赛事，确定赛事规模",parent=BaseEntity.class)
public class MrtonSafetyGrasp extends BaseEntity{

    private static final long serialVersionUID=1L;
    
    @ApiModelProperty(value="id",name="id")
    private Integer id;
        
    @ApiModelProperty(value="任务ID",name="procId")
    private String procId;
        
    @ApiModelProperty(value="项目设置",name="projectSetting")
    private String projectSetting;
        
    @ApiModelProperty(value="各项目人数",name="projectNum")
    private Integer projectNum;
        
    @ApiModelProperty(value="赛事规格",name="mrtonStandard")
    private String mrtonStandard;
    
}

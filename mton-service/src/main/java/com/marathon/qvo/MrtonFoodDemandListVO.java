package com.marathon.qvo;

import com.marathon.domain.MrtonFoodDemand;
import lombok.Data;

/**
 * @author cuiguangqiang
 * @version MrtonFoodDemandListVO, v0.1 2020/6/29 8:30
 * @description 类说明
 */
@Data
public class MrtonFoodDemandListVO extends MrtonFoodDemand {

    private String stageStr;

    private String serviceTimeStr;


}

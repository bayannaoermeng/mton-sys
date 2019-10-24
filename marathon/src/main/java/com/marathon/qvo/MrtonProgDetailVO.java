package com.marathon.qvo;

import com.google.common.collect.Lists;
import com.ruoyi.common.base.BaseEntity;
import lombok.Data;

import java.util.List;

/**
 * @author cuiguangqiang
 * @version MrtonProgDetailVO, v0.1 2019/10/23 15:30
 * @description 赛事进度监控详情
 */

@Data
public  class MrtonProgDetailVO extends BaseEntity {

    //赛事名称
    private String mrtonName;

    private List<TaskProgDetail> lstTaskProgDetail= Lists.newArrayList();

    @Data
    public class TaskProgDetail{

        private String taskName;

        //总任务数量
        private Integer total;

        //已完成
        private Integer finished=0;

        //已滞后
        private Integer lagging;

        //完成率
        private String completionRate;
    }

}

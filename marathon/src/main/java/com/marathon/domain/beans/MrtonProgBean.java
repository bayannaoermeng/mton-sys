package com.marathon.domain.beans;

import lombok.Data;

/**
 * @author cuiguangqiang
 * @version MrtonProgBean, v0.1 2019/10/23 16:44
 * @description 类说明
 */
@Data
public class MrtonProgBean {

    //赛事ID
    private String mrtonId;
    //赛事名称
    private String mrtonName;
    //模块任务ID
    private String procId;
    //模块任务名称
    private String procName;
    //统计数据
    private Integer number;

}

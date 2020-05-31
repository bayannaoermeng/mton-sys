package com.marathon.qvo;

import lombok.Data;

import java.util.Date;

/**
 * @author cuiguangqiang
 * @version MrthonMenuBean, v0.1 2019/10/18 17:22
 * @description 类说明
 */
@Data
public class MrthonMenuBean {

    //赛事ID
    private String marathonId;

    //模块名称
    private String procName;

    //赛事名称
    private String mrtonName;

    //开始日期
    private long starttime;

}

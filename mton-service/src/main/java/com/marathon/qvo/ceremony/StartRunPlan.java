package com.marathon.qvo.ceremony;

import lombok.Data;

/**
 * @author cuiguangqiang
 * @version StartRunPlan, v0.1 2020/5/5 10:15
 * @description 起跑仪式方案模板参数
 */
@Data
public class StartRunPlan extends CommonPlan {
    private String title;
    private String hostOpen;
    private String endtime;
    private String starttime;
    private String playAnthem;
    private String gameStart;
    private String fireGun;
    private String location;
    private String warmShow;
    private String guestShow;
    private String athleteWarm;
    private String introduction;
    private String participants;
}

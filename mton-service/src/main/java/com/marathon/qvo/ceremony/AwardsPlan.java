package com.marathon.qvo.ceremony;

import lombok.Data;

/**
 * @author cuiguangqiang
 * @version AwardsPlan, v0.1 2020/5/8 18:27
 * @description 颁奖仪式方案
 */
@Data
public class AwardsPlan {

    private String title;

    private String time;

    private String location;

    private String guestMenModal;
    private String guestMenTrophy;
    private String guestMenCheck;
    private String guestMenPrize;
    private String guestWomenModal;
    private String guestWomenTrophy;
    private String guestWomenCheck;
    private String guestWomenPrize;

    private String menAwardsTime;//男子组颁奖仪式
    private String menPlayTime;//             主持人邀请运动员、颁奖嘉宾上场
    private String menIntrTime;//             主持人介绍颁奖嘉宾、获奖运动员
    private String menModalTime;//             为前三名颁发奖牌
    private String menTrophyTime;//             为前三名颁发奖杯
    private String menCheckTime;//             为前三名颁发支票
    private String menPrizeTime;//             为前三名颁发奖品
    private String menPhotoTime;//             嘉宾和运动员合影留念

    private String womenAwardsTime;//  女子组颁奖仪式
    private String womenPlayTime;//             主持人邀请运动员、颁奖嘉宾上场
    private String womenIntrTime;//             主持人介绍颁奖嘉宾、获奖运动员
    private String womenModalTime;//             为前三名颁发奖牌
    private String womenTrophyTime;//             为前三名颁发奖杯
    private String womenCheckTime;//             为前三名颁发支票
    private String womenPrizeTime;//             为前三名颁发奖品
    private String womenPhotoTime;//             嘉宾和运动员合影留念

    private String endTime;//             颁奖仪式结束


}

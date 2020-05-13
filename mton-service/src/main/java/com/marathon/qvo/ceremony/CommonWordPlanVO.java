package com.marathon.qvo.ceremony;

import lombok.Data;

/**
 * @author cuiguangqiang
 * @version CommonWordPlanVO, v0.1 2020/5/12 17:05
 * @description word生成任务初始化数据结构
 */
@Data
public class CommonWordPlanVO<T> {

    // StartRunPlan,AwardPlan
    private T bean;

    // 预览URL
    private String previewUrl;

}

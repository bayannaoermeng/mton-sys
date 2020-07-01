package com.marathon.qvo.ceremony;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author cuiguangqiang
 * @version ApproveInfo, v0.1 2020/7/1 8:29
 * @description 审核意见类
 */
@Data
public class ApproveInfo {

    private String remark;

    private String approver;

    private LocalDateTime approveTime;

    private String approveTimeStr;

}

package com.marathon.domain.beans;

import lombok.Data;

/**
 * @author cuiguangqiang
 * @version WorkFlowApproveListBean, v0.1 2020/6/17 8:01
 * @description 类说明
 */

@Data
public class WorkFlowApproveListBean {

    //任务ID
    private String procId;

    //赛事名称
    private String mrtonName;

    //任务名称
    private String procName;

    //审核节点名称
    private String nodeName;

}

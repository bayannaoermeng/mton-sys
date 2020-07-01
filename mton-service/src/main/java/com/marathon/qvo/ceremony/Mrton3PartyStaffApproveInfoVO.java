package com.marathon.qvo.ceremony;

import org.apache.commons.compress.utils.Lists;

import java.util.List;

/**
 * @author cuiguangqiang
 * @version Mrton3PartyStaffApproveInfoVO, v0.1 2020/7/1 8:26
 * @description 第三人员需求审核详情数据结构
 */
public class Mrton3PartyStaffApproveInfoVO {

    List<Mrton3PartyStaffVO> lst3PartyStaff;

    List<ApproveInfo> lstApprove;

    public List<Mrton3PartyStaffVO> getLst3PartyStaff() {
        if (lst3PartyStaff == null) {
            lst3PartyStaff = Lists.newArrayList();
        }
        return lst3PartyStaff;
    }

    public List<ApproveInfo> getLstApprove() {
        if (lstApprove == null) {
            lstApprove = Lists.newArrayList();
        }
        return lstApprove;
    }
}

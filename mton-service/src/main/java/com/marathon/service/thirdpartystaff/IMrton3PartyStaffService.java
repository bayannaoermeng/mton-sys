package com.marathon.service.thirdpartystaff;

import com.marathon.domain.Mrton3PartyStaff;
import com.marathon.qvo.ceremony.Mrton3PartyStaffApproveInfoVO;
import com.marathon.qvo.ceremony.Mrton3PartyStaffVO;

import java.util.List;

public interface IMrton3PartyStaffService {


    int insertMrton3PartyStaff(Mrton3PartyStaff mrton3PartyStaff);

    Mrton3PartyStaffVO selectMrton3PartyStaffById(Integer id);

    int updateMrton3PartyStaff(Mrton3PartyStaff mrton3PartyStaff);

    int deleteMrton3PartyStaffByIds(String ids);

    List<Mrton3PartyStaffVO> selectByProcId(String procid);

    //置成供应商
    void setMaster(String id);

    /**
     * 提交申请
     * @param procId
     * @param userId
     */
    void apply(String procId, Long userId);

    /**
     * 检查是否已被提交过
     * @param procId
     */
    void checkApproved(String procId);

    /**
     * 查询审核信息
     * @param mrtonprocid
     * @return
     */
    Mrton3PartyStaffApproveInfoVO selectApproveInfo(String mrtonprocid);
}

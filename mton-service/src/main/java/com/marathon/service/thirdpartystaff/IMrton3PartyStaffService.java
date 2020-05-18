package com.marathon.service.thirdpartystaff;

import com.marathon.domain.Mrton3PartyStaff;

import java.util.List;

public interface IMrton3PartyStaffService {


    int insertMrton3PartyStaff(Mrton3PartyStaff mrton3PartyStaff);

    Mrton3PartyStaff selectMrton3PartyStaffById(Integer id);

    int updateMrton3PartyStaff(Mrton3PartyStaff mrton3PartyStaff);

    int deleteMrton3PartyStaffByIds(String ids);

    List<Mrton3PartyStaff> selectByProcId(String procid);

}

package com.marathon.service.thirdpartystaff.impl;

import com.marathon.domain.Mrton3PartyStaff;
import com.marathon.domain.Mrton3PartyStaffExample;
import com.marathon.mapper.Mrton3PartyStaffMapper;
import com.marathon.service.thirdpartystaff.IMrton3PartyStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cuiguangqiang
 * @version Mrton3PartyStaffServiceImpl, v0.1 2020/5/16 15:02
 * @description 类说明
 */
@Service
public class Mrton3PartyStaffServiceImpl implements IMrton3PartyStaffService {

    @Autowired
    private Mrton3PartyStaffMapper mrton3PartyStaffMapper;


    @Override
    public int insertMrton3PartyStaff(Mrton3PartyStaff mrton3PartyStaff) {
        return mrton3PartyStaffMapper.insertSelective(mrton3PartyStaff);
    }

    @Override
    public Mrton3PartyStaff selectMrton3PartyStaffById(Integer id) {
        return mrton3PartyStaffMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateMrton3PartyStaff(Mrton3PartyStaff mrton3PartyStaff) {
        return mrton3PartyStaffMapper.updateByPrimaryKey(mrton3PartyStaff);
    }

    @Override
    public int deleteMrton3PartyStaffByIds(String ids) {
        return mrton3PartyStaffMapper.deleteByPrimaryKey(Integer.valueOf(ids));
    }

    @Override
    public List<Mrton3PartyStaff> selectByProcId(String procid) {
        Mrton3PartyStaffExample staff = new Mrton3PartyStaffExample();
        staff.or().andProcIdEqualTo(procid);
        return mrton3PartyStaffMapper.selectByExample(staff);
    }
}

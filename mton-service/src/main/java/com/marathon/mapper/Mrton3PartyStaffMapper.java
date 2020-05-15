package com.marathon.mapper;

import com.marathon.domain.Mrton3PartyStaff;
import com.marathon.domain.Mrton3PartyStaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Mrton3PartyStaffMapper {
    int countByExample(Mrton3PartyStaffExample example);

    int deleteByExample(Mrton3PartyStaffExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Mrton3PartyStaff record);

    int insertSelective(Mrton3PartyStaff record);

    List<Mrton3PartyStaff> selectByExample(Mrton3PartyStaffExample example);

    Mrton3PartyStaff selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mrton3PartyStaff record, @Param("example") Mrton3PartyStaffExample example);

    int updateByExample(@Param("record") Mrton3PartyStaff record, @Param("example") Mrton3PartyStaffExample example);

    int updateByPrimaryKeySelective(Mrton3PartyStaff record);

    int updateByPrimaryKey(Mrton3PartyStaff record);
}
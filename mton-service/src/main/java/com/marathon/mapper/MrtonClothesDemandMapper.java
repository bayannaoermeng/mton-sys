package com.marathon.mapper;

import com.marathon.domain.MrtonClothesDemand;
import com.marathon.domain.MrtonClothesDemandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MrtonClothesDemandMapper {
    int countByExample(MrtonClothesDemandExample example);

    int deleteByExample(MrtonClothesDemandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MrtonClothesDemand record);

    int insertSelective(MrtonClothesDemand record);

    List<MrtonClothesDemand> selectByExample(MrtonClothesDemandExample example);

    MrtonClothesDemand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MrtonClothesDemand record, @Param("example") MrtonClothesDemandExample example);

    int updateByExample(@Param("record") MrtonClothesDemand record, @Param("example") MrtonClothesDemandExample example);

    int updateByPrimaryKeySelective(MrtonClothesDemand record);

    int updateByPrimaryKey(MrtonClothesDemand record);
}
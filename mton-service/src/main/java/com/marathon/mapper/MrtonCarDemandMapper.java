package com.marathon.mapper;

import com.marathon.domain.MrtonCarDemand;
import com.marathon.domain.MrtonCarDemandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MrtonCarDemandMapper {
    int countByExample(MrtonCarDemandExample example);

    int deleteByExample(MrtonCarDemandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MrtonCarDemand record);

    int insertSelective(MrtonCarDemand record);

    List<MrtonCarDemand> selectByExample(MrtonCarDemandExample example);

    MrtonCarDemand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MrtonCarDemand record, @Param("example") MrtonCarDemandExample example);

    int updateByExample(@Param("record") MrtonCarDemand record, @Param("example") MrtonCarDemandExample example);

    int updateByPrimaryKeySelective(MrtonCarDemand record);

    int updateByPrimaryKey(MrtonCarDemand record);
}
package com.marathon.mapper;

import com.marathon.domain.MrtonFoodDemand;
import com.marathon.domain.MrtonFoodDemandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MrtonFoodDemandMapper {
    long countByExample(MrtonFoodDemandExample example);

    int deleteByExample(MrtonFoodDemandExample example);

    int insert(MrtonFoodDemand record);

    int insertSelective(MrtonFoodDemand record);

    List<MrtonFoodDemand> selectByExample(MrtonFoodDemandExample example);

    int updateByExampleSelective(@Param("record") MrtonFoodDemand record, @Param("example") MrtonFoodDemandExample example);

    int updateByExample(@Param("record") MrtonFoodDemand record, @Param("example") MrtonFoodDemandExample example);
}
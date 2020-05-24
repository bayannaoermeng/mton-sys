package com.marathon.mapper;

import com.marathon.domain.MrtonStageFlow;
import com.marathon.domain.MrtonStageFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MrtonStageFlowMapper {
    int countByExample(MrtonStageFlowExample example);

    int deleteByExample(MrtonStageFlowExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MrtonStageFlow record);

    int insertSelective(MrtonStageFlow record);

    List<MrtonStageFlow> selectByExample(MrtonStageFlowExample example);

    MrtonStageFlow selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MrtonStageFlow record, @Param("example") MrtonStageFlowExample example);

    int updateByExample(@Param("record") MrtonStageFlow record, @Param("example") MrtonStageFlowExample example);

    int updateByPrimaryKeySelective(MrtonStageFlow record);

    int updateByPrimaryKey(MrtonStageFlow record);
}
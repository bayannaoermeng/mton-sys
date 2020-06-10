package com.marathon.mapper;

import com.marathon.domain.MrtonProcWorkflow;
import com.marathon.domain.MrtonProcWorkflowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MrtonProcWorkflowMapper {
    int countByExample(MrtonProcWorkflowExample example);

    int deleteByExample(MrtonProcWorkflowExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MrtonProcWorkflow record);

    int insertSelective(MrtonProcWorkflow record);

    List<MrtonProcWorkflow> selectByExample(MrtonProcWorkflowExample example);

    MrtonProcWorkflow selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MrtonProcWorkflow record, @Param("example") MrtonProcWorkflowExample example);

    int updateByExample(@Param("record") MrtonProcWorkflow record, @Param("example") MrtonProcWorkflowExample example);

    int updateByPrimaryKeySelective(MrtonProcWorkflow record);

    int updateByPrimaryKey(MrtonProcWorkflow record);
}
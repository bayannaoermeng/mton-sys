package com.marathon.mapper;

import com.marathon.domain.workflow.WorkflowNode;
import com.marathon.domain.workflow.WorkflowNodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkflowNodeMapper {
    int countByExample(WorkflowNodeExample example);

    int deleteByExample(WorkflowNodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WorkflowNode record);

    int insertSelective(WorkflowNode record);

    List<WorkflowNode> selectByExample(WorkflowNodeExample example);

    WorkflowNode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WorkflowNode record, @Param("example") WorkflowNodeExample example);

    int updateByExample(@Param("record") WorkflowNode record, @Param("example") WorkflowNodeExample example);

    int updateByPrimaryKeySelective(WorkflowNode record);

    int updateByPrimaryKey(WorkflowNode record);
}
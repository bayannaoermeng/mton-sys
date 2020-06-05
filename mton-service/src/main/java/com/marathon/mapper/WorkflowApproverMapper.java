package com.marathon.mapper;

import com.marathon.domain.workflow.WorkflowApprover;
import com.marathon.domain.workflow.WorkflowApproverExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkflowApproverMapper {
    int countByExample(WorkflowApproverExample example);

    int deleteByExample(WorkflowApproverExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WorkflowApprover record);

    int insertSelective(WorkflowApprover record);

    List<WorkflowApprover> selectByExample(WorkflowApproverExample example);

    WorkflowApprover selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WorkflowApprover record, @Param("example") WorkflowApproverExample example);

    int updateByExample(@Param("record") WorkflowApprover record, @Param("example") WorkflowApproverExample example);

    int updateByPrimaryKeySelective(WorkflowApprover record);

    int updateByPrimaryKey(WorkflowApprover record);
}
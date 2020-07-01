package com.marathon.mapper;

import com.marathon.domain.WorkflowBusiness;
import com.marathon.domain.WorkflowBusinessExample;
import java.util.List;

import com.marathon.qvo.ceremony.ApproveInfo;
import org.apache.ibatis.annotations.Param;

public interface WorkflowBusinessMapper {
    int countByExample(WorkflowBusinessExample example);

    int deleteByExample(WorkflowBusinessExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WorkflowBusiness record);

    int insertSelective(WorkflowBusiness record);

    List<WorkflowBusiness> selectByExample(WorkflowBusinessExample example);

    WorkflowBusiness selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WorkflowBusiness record, @Param("example") WorkflowBusinessExample example);

    int updateByExample(@Param("record") WorkflowBusiness record, @Param("example") WorkflowBusinessExample example);

    int updateByPrimaryKeySelective(WorkflowBusiness record);

    int updateByPrimaryKey(WorkflowBusiness record);

    List<ApproveInfo> selectApproveInfo(String mrtonprocid);
}
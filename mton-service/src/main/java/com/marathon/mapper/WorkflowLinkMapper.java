package com.marathon.mapper;

import com.marathon.domain.workflow.WorkflowLink;
import com.marathon.domain.workflow.WorkflowLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkflowLinkMapper {
    int countByExample(WorkflowLinkExample example);

    int deleteByExample(WorkflowLinkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WorkflowLink record);

    int insertSelective(WorkflowLink record);

    List<WorkflowLink> selectByExample(WorkflowLinkExample example);

    WorkflowLink selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WorkflowLink record, @Param("example") WorkflowLinkExample example);

    int updateByExample(@Param("record") WorkflowLink record, @Param("example") WorkflowLinkExample example);

    int updateByPrimaryKeySelective(WorkflowLink record);

    int updateByPrimaryKey(WorkflowLink record);
}
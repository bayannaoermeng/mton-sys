package com.marathon.service.workflow.impl;

import com.marathon.mapper.MrtonProcWorkflowMapper;
import com.marathon.service.workflow.IWorkFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cuiguangqiang
 * @version WorkFlowServiceImpl, v0.1 2020/6/15 8:00
 * @description 类说明
 */
@Service
public class WorkFlowServiceImpl implements IWorkFlowService {

    @Autowired
    private MrtonProcWorkflowMapper mrtonProcWorkflowMapper;


}

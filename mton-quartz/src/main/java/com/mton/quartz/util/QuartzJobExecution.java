package com.mton.quartz.util;

import com.mton.quartz.domain.SysJob;
import org.quartz.JobExecutionContext;

import java.lang.reflect.InvocationTargetException;

/**
 * 定时任务处理（允许并发执行）
 *
 * @author mton
 */
public class QuartzJobExecution extends AbstractQuartzJob {
    @Override
    protected void doExecute(JobExecutionContext context, SysJob sysJob) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {
        JobInvokeUtil.invokeMethod(sysJob);
    }
}

package com.mton.common.utils;

import cn.hutool.core.util.StrUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 错误信息处理类。
 *
 * @author mton
 */
public class ExceptionUtil {

    private ExceptionUtil(){
        throw new IllegalStateException("Utility class");
    }

    /**
     * 获取exception的详细错误信息。
     */
    public static String getExceptionMessage(Throwable e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw, true));
        return sw.toString();
    }
}

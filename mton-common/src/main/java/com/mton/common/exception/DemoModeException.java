package com.mton.common.exception;

/**
 * 演示模式异常
 *
 * @author mton
 */
public class DemoModeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage(){
        return "演示模式，禁止操作";
    }
}

package com.marathon.service.workflow;

public enum WorkFlowEnum {

    WORK_FLOW_ANCHOR(1, "主持人需求审批流程");

    private final Integer code;
    private final String name;

    WorkFlowEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}

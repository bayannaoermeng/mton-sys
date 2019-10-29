package com.marathon;

/**
 * 安保子任务枚举
 */
public enum MrtonSafetyChildTaskEnum {

    CHILD_GRASP(1, "了解赛事，确定赛事规模");

    MrtonSafetyChildTaskEnum(int sort, String name) {
        this.sort = sort;
        this.name = name;
    }

    private final int sort;
    private final String name;

    public int getSort() {
        return sort;
    }

    public String getName() {
        return name;
    }
}

package com.marathon;

public enum MrtonProcStatusEnum {

    STATUS_NEW(0,"新建"),STATUS_RUNNING(1,"进行中"), FINISH(4,"结束" );

    private final int key;
    private final String value;

    MrtonProcStatusEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static MrtonProcStatusEnum getObject(int key){
        MrtonProcStatusEnum[] array = values();
        for (MrtonProcStatusEnum MrtonProcEnum : array) {
            if (key == MrtonProcEnum.getKey()) {
                return MrtonProcEnum;
            }
        }
        throw new IllegalArgumentException();
    }
}

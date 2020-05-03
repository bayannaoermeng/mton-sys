package com.marathon;

/**
 * 赛事过程枚举（安保、报名、竞赛等）
 */
public enum MrtonProcEnum {

    SAFTY_PROTECTION(12,"安保"),LIVING_PRO(11,"直播"),CEREMONY_PRO(10,"仪式");
    private final int sequence;
    private final String name;

    MrtonProcEnum(int sequence,String name) {
        this.sequence=sequence;
        this.name=name;
    }

    public int getSequence() {
        return sequence;
    }

    public String getName() {
        return name;
    }

    public static MrtonProcEnum getValue(int sequence){
        MrtonProcEnum[] array = values();
        for (MrtonProcEnum MrtonProcEnum : array) {
            if (sequence == MrtonProcEnum.getSequence()) {
                return MrtonProcEnum;
            }
        }
        throw new IllegalArgumentException();
    }
}

package com.marathon;

public enum MrthonMenuEnum {

    MRTON_MENU_NAME_SAFETY("安全防护","mrtonproc/safety/%s");

    private final String menuName;
    private final String url;

    MrthonMenuEnum(String menuName, String url) {
        this.menuName = menuName;
        this.url = url;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getUrl() {
        return url;
    }

    public static MrthonMenuEnum getValue(String menuName){
        MrthonMenuEnum[] array = values();
        for (MrthonMenuEnum MrthonMenuEnum : array) {
            if (menuName.equals(MrthonMenuEnum.getMenuName())) {
                return MrthonMenuEnum;
            }
        }
        return null;
    }
}

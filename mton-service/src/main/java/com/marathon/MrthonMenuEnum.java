package com.marathon;

public enum MrthonMenuEnum {

    MRTON_MENU_NAME_SAFETY("安保","mrtonproc/safety/%s"),MRTON_MENU_NAME_LIIVNG("直播","mrtonproc/living/%s"),
    MRTON_MENU_NAME_CEREMONY("仪式","ceremony/init/%s");

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

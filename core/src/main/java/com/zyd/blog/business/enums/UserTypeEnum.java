package com.zyd.blog.business.enums;

public enum UserTypeEnum {
    ROOT("超级管理员"),
    ADMIN("管理员"),
    USER("系统会员"),
    UNKNOW("未知");

    private String desc;

    UserTypeEnum(String desc) {
        this.desc = desc;
    }

    public static UserTypeEnum getBytype(String type) {
        if (type == null) {return UNKNOW;}
        for (UserTypeEnum value : UserTypeEnum.values()) {
            if (value.name().equals(type)) {
                return value;
            }
        }
        return UNKNOW;
    }

    public String getByTypeDesc(String type) {
        if (type == null) {
            return UNKNOW.getDesc();
        }

        for (UserTypeEnum ut : UserTypeEnum.values()) {
            if (ut.toString().equalsIgnoreCase(type)) {
                return ut.getDesc();
            }
        }

        return UserTypeEnum.UNKNOW.getDesc();
    }

    public String getDesc() {
        return desc;
    }

}

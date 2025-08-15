package com.zyd.blog.business.enums;

public enum UserStatusEnum {
    NORMAL(1, "正常"),
    DISABLED(0, "禁用")
    ;
    Integer code;
    String desc;

    UserStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static UserStatusEnum getByCode(Integer code) {
        if (code == null) {
            return NORMAL;
        }
        for (UserStatusEnum value : UserStatusEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return NORMAL;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}

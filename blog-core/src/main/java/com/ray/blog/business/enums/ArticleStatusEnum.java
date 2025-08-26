package com.ray.blog.business.enums;

public enum ArticleStatusEnum {
    PUBLISHED (1, "已发布"),
    UNPUBLISHED (0, "未发布");;

    private int code;
    private String desc;

    ArticleStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ArticleStatusEnum getByCode(Integer code) {
        if (code == null) {
            return PUBLISHED;
        }
        for (ArticleStatusEnum value : ArticleStatusEnum.values()) {
            if (value.getcode() == code) {
                return value;
            }
        }
        return PUBLISHED;
    }

    public int getcode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

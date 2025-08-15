package com.zyd.blog.business.enums;

public enum ConfigKeyEnum {
    SITE_NAME("siteName"),           // 网站名称
    DOMAIN("domain"),                // 主域名
    SITE_URL("siteUrl"),             // 博客地址
    STORAGE_TYPE("storageType");    // 存储类型

    private final String key;

    ConfigKeyEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}

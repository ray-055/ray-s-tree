package com.ray.blog.business.enums;

public enum ResponseStatus {
    SUCCESS(200, "success"),
    ERROR(500, "error"),
    INVALID_PARAM(500, "invalid param"),
    NOT_FOUND(404, "not found"),
    UPLOAD_FILE_ERROR(500, "upload file error"),
    ;
    private Integer code;
    private String message;

    ResponseStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseStatus getResponseStatus(String message) {
        for (ResponseStatus ut : ResponseStatus.values()) {
            if (ut.getMessage() == message) {
                return ut;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
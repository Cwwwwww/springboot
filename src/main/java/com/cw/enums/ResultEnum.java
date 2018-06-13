package com.cw.enums;

/**
 * result对象内容可能值的枚举类型
 */
public enum ResultEnum {
    /* 枚举集合 */
    UNKNOWN_ERROR(-1, "未知错误"),
    SUCCESS(0, "success"),
    PRIMARY_SCHOOL(100, "你还在上小学"),
    MIDDLE_SCHOOL(101, "你在上中学");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

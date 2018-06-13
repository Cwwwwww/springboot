package com.cw.exception;

import com.cw.enums.ResultEnum;

/**
 * 自定义异常类型，注意继承的是RuntimeException
 */
public class GirlException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer code;

    /**
     * 构造方法，参数为结果变量的枚举类型
     * @param re
     */
    public GirlException(ResultEnum re) {
        super(re.getMsg());
        this.code = re.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

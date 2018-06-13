package com.cw.utils;

import com.cw.entity.Result;
import com.cw.enums.ResultEnum;

/**
 * 对Result类型返回结果的一个处理
 */
public class ResultUtil {

    /**
     * 有参数操作成功时的处理方式
     * @param object
     * @return
     */
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    /**
     * 无参操作成功时的处理
     */
    public static Result success() {
        return success(null);
    }

    /**
     * 操作失败时的处理方式
     * @param code
     * @param msg
     * @return
     */
    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}

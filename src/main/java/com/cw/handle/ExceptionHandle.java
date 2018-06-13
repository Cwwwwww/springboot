package com.cw.handle;

import com.cw.entity.Result;
import com.cw.enums.ResultEnum;
import com.cw.exception.GirlException;
import com.cw.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 捕获异常的类，其中包含异常处理的方法
 */
@ControllerAdvice
public class ExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handler(Exception e) {
        //首先判断是不是我们恩自定义的异常类型，如果是，返回错误编码以及提示信息，如果不是则返回"系统异常"的提示信息
        if (e instanceof GirlException) {
            GirlException ge = (GirlException)e;
            return ResultUtil.error(ge.getCode(), ge.getMessage());
        } else {
            logger.error("【系统异常】：{}", e);
            return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
        }
    }
}

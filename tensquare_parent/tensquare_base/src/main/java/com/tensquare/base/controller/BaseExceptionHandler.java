package com.tensquare.base.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName BaseExceptionHandler
 * @Description 公共异常处理类
 * @Author lenovo
 * @Date 2020/4/26 23:35
 * @Version 1.0
 **/
@ControllerAdvice//用于拦截全局的Controller的异常
public class BaseExceptionHandler {

    //设置要捕获的异常，并作出处理,这里将异常以json形式返回
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception exception) {
        exception.printStackTrace();
        return new Result(false, StatusCode. ERROR, "执行出现异常：" + exception.getMessage());
    }


}

package com.springboot.database.handle;

import com.springboot.database.domain.Result;
import com.springboot.database.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: database
 * @description: 异常捕获类
 * @author: JunOba
 * @create: 2018-12-07 20:55
 **/
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        return ResultUtil.error(100, e.getMessage());
    }
}

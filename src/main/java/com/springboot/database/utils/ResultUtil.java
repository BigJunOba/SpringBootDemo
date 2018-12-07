package com.springboot.database.utils;

import com.springboot.database.domain.Result;
import com.springboot.database.enums.ResultEnum;
import jdk.nashorn.internal.ir.ReturnNode;

/**
 * @program: database
 * @description: Http最外层对象工具类
 * @author: JunOba
 * @create: 2018-12-07 20:25
 **/
public class ResultUtil {

    public static Result success(Object object) {
        return new Result(ResultEnum.SUCCESS, object);
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}

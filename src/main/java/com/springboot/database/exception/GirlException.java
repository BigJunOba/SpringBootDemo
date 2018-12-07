package com.springboot.database.exception;

import com.springboot.database.enums.ResultEnum;

/**
 * @program: database
 * @description: 关于年龄的异常类
 * @author: JunOba
 * @create: 2018-12-07 21:01
 **/
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

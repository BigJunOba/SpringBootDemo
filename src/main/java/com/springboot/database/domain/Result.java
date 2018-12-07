package com.springboot.database.domain;

import com.springboot.database.enums.ResultEnum;

/**
 * @program: database
 * @description: Http请求返回的最外层对象
 * @author: JunOba
 * @create: 2018-12-07 18:49
 **/
public class Result<T> {

    /** 错误码。*/
    private Integer code;

    /** 提示信息。*/
    private String msg;

    /** 具体的内容.*/
    private T data;

    public Result() {
    }

    public Result(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

package com.tensquare.entity;

import lombok.Data;

/**
 * @Classname Result
 * @Description 公共实体类返回
 * @Date 2020/4/11 0011 16:54
 * @Created by Administrator
 * @auth haoyang
 */
@Data
public class Result {
    /**
     * 是否成功
     */
    private boolean flag;

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;

    public Result(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result() {
    }
}

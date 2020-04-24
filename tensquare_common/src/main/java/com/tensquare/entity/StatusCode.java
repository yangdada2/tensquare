package com.tensquare.entity;

/**
 * @Classname StatusCode
 * @Description 状态码返回实体类
 * @Date 2020/4/11 0011 17:25
 * @Created by Administrator
 * @auth haoyang
 */
public class StatusCode {
    /**
     * 成功状态码
     */
    public static final int OK = 20000;
    /**
     * 失败返回码
     */
    public static final int ERROR = 20001;
    /**
     * 用户名或者密码错误
     */
    public static final int LOGINERROR = 20002;
    /**
     * 权限不足
     */
    public static final int ACCESSERROR = 20003;
    /**
     * 远程调用失败
     */
    public static final int REMOTEERROR = 20004;
    /**
     * 重复操作
     */
    public static final int REPERROR = 20005;
    /**
     * 参数错误
     */
    public static final int PARAMERROR = 20006;
}

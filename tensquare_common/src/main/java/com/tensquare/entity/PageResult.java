package com.tensquare.entity;

/**
 * @Classname PageResult
 * @Description 分页返回实体类
 * @Date 2020/4/11 0011 17:22
 * @Created by Administrator
 * @auth haoyang
 */

import lombok.Data;

import java.util.List;

/**
 * 使用泛型
 * @param <T>
 */
@Data
public class PageResult<T> {
    /**
     * 总条数
     */
    private Long total;

    /**
     * 返回实体类对象
     */
    private List<T> rows;

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
}

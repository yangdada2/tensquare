package com.tensquare.base.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Classname Label
 * @Description 标签实体类
 * @Date 2020/4/11 0011 19:38
 * @Created by Administrator
 * @author haoyang
 */
@Data
@Entity
@Table(name = "tb_label")
public class Label {
    @Id
    private String id;
    /**
     * 标签名称
     */
    private String labelname;
    /**
     * 状态
     */
    private String state;
    /**
     * 使用数量
     */
    private Long count;
    /**
     * 关注数
     */
    private Long fans;
    /**
     * 是否推荐
     */
    private String recommend;
}

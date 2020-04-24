package com.tensquare.base.dao;

import com.tensquare.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author haoyang
 * @Classname LabelDao
 * @Description 标签持久层
 * @Date 2020/4/11 0011 19:41
 * @Created by Administrator
 *
 *  JpaRepository提供简单的增删改查, JpaSpecificationExecutor提供复杂的条件查询
 */
public interface LabelDao extends JpaRepository<Label,String>,JpaSpecificationExecutor<Label> {

}

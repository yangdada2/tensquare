package com.tensquare.article.dao;

import com.tensquare.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author haoyang
 * @Classname CommentDao
 * @Description 文章评论持久层(使用的是MongoDb)
 * @Date 2020/4/13 0013 14:09
 * @Created by Administrator
 */
public interface CommentDao extends MongoRepository<Comment,String> {

    /**
     * 根据文章ID查询评论列表
     * @param articleid
     * @return
     */
    public List<Comment> findByArticleid(String articleid);
}

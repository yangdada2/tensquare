package com.tensquare.article.service;

import com.tensquare.article.dao.CommentDao;
import com.tensquare.article.pojo.Comment;
import com.tensquare.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author haoyang
 * @Classname CommentService
 * @Description 文章评论业务逻辑层
 * @Date 2020/4/13 0013 14:11
 * @Created by Administrator
 */
@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 新增评论
     */
    public void add(Comment comment){
        comment.set_id( idWorker.nextId()+""  );
        commentDao.save(comment);
    }

    public List<Comment> findByArticleid(String articleid){
        return commentDao.findByArticleid(articleid);
    }

    /**
     * 删除评论
     */
    public void delete(String id){
        commentDao.deleteById(id);
    }
}

package com.tensquare.article.controller;

import com.tensquare.article.pojo.Comment;
import com.tensquare.article.service.CommentService;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author haoyang
 * @Classname CommentController
 * @Description 文章评论控制层
 * @Date 2020/4/13 0013 14:13
 * @Created by Administrator
 */
@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 保存评论
     *
     * @param comment
     * @return
     */
    @RequestMapping(method= RequestMethod.POST)
    public Result save(@RequestBody Comment comment){
        commentService.add(comment);
        return new Result(true, StatusCode.OK, "提交成功");
    }

    /**
     * 根据文章id查询评论列表
     *
     * @param articleid
     * @return
     */
    @RequestMapping(value="/article/{articleid}",method= RequestMethod.GET)
    public Result findByArticleid(@PathVariable String articleid){
        return new Result(true, StatusCode.OK, "查询成功",  commentService.findByArticleid(articleid));
    }

    /**
     * 删除评论
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method= RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
        commentService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功!");
    }
}

package com.tensquare.article.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haoyang
 * @Classname Comment
 * @Description 文章评论
 * @Date 2020/4/13 0013 14:08
 * @Created by Administrator
 */
@Data
public class Comment implements Serializable{
    @Id
    private String _id;
    private String articleid;
    private String content;
    private String userid;
    private String parentid;
    private Date publishdate;
}

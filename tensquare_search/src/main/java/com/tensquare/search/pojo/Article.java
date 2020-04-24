package com.tensquare.search.pojo;

/**
 * @author haoyang
 * @Classname Article
 * @Description TODO
 * @Date 2020/4/14 0014 10:15
 * @Created by Administrator
 */

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * 文章实体类
 */
@Data
@Document(indexName="tensquare",type="article")
public class Article implements Serializable {
    @Id
    private String id;//ID

    @Field(index= true ,analyzer="ik_max_word",searchAnalyzer="ik_max_word")
    private String title;//标题

    @Field(index= true ,analyzer="ik_max_word",searchAnalyzer="ik_max_word")
    private String content;//文章正文

    private String state;//审核状态

}

package com.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BasicBSONObject;
import org.bson.Document;
import org.junit.After;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author haoyang
 * @Classname Test
 * @Description mongo测试类
 * @Date 2020/4/13 0013 12:47
 * @Created by Administrator
 */
public class Test {

    private static MongoClient client=new MongoClient("192.168.128.133");//创建连接
    private static MongoDatabase spitdb = client.getDatabase("splitdb");//打开数据库

    public static void main(String[] args) {
        MongoCollection<Document> spit = spitdb.getCollection("spit");//获取集合
        FindIterable<Document> documents = spit.find();//查询记录获取文档集合
        for(Document document:documents){ //
            System.out.println("内容："+  document.getString("content"));
            System.out.println("用户ID:"+document.getString("userid"));
            System.out.println("浏览量："+document.getInteger("visits"));
        }
        client.close();//关闭连接
    }

    /**
     * 查询所有文档记录
     */
    @org.junit.Test
    public void test1() {
        MongoCollection<Document> spit = spitdb.getCollection("spit");//获取集合
        FindIterable<Document> documents = spit.find();//查询记录获取文档集合
        for(Document document:documents){ //
            System.out.println("内容："+  document.getString("content"));
            System.out.println("用户ID:"+document.getString("userid"));
            System.out.println("浏览量："+document.getInteger("visits"));
        }
        client.close();//关闭连接
    }

    /**
     * 查询userid为1013的记录
     */
    @org.junit.Test
    public void test2() {
        MongoCollection<Document> spit = spitdb.getCollection("spit");//获取集合
        //构建查询条件
        BasicDBObject bson=new BasicDBObject("userid","1013");
        FindIterable<Document> filter = spit.find(bson);
        for(Document document:filter){ //
            System.out.println("内容："+  document.getString("content"));
            System.out.println("用户ID:"+document.getString("userid"));
            System.out.println("浏览量："+document.getInteger("visits"));
        }
        client.close();//关闭连接
    }

    /**
     * 查询浏览量大于1000的记录
     */
    @org.junit.Test
    public void test3() {
        MongoCollection<Document> spit = spitdb.getCollection("spit");//获取集合
        //构建查询条件
        BasicDBObject bson=new BasicDBObject("visits",new BasicDBObject("$gt",1000));
        FindIterable<Document> filter = spit.find(bson);
        for(Document document:filter){ //
            System.out.println("内容："+  document.getString("content"));
            System.out.println("用户ID:"+document.getString("userid"));
            System.out.println("浏览量："+document.getInteger("visits"));
        }
        client.close();//关闭连接
    }

    /**
     * 插入数据
     */
    @org.junit.Test
    public void test4() {
        MongoCollection<Document> spit = spitdb.getCollection("spit");//获取集合


        //需要插入的数据
        Map<String,Object> params = new HashMap<>();
        params.put("content","杨浩准备掏吐槽了!");
        params.put("userid","9999");
        params.put("visits",10000);
        params.put("publishtime",new Date());
        Document document = new Document(params);
        spit.insertOne(document);
        client.close();//关闭连接
    }
}

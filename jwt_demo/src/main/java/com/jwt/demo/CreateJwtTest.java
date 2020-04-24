package com.jwt.demo;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author haoyang
 * @Classname CreateJwtTest
 * @Description JWT创建测试类
 * @Date 2020/4/16 0016 15:19
 * @Created by Administrator
 */
public class CreateJwtTest {

    public static void main(String[] args) {
        JwtBuilder jwtBuilder = Jwts.builder().setId("1")
                .setSubject("杨大大")
                //setIssuedAt用于设置签发时间
                .setIssuedAt(new Date())
                //signWith用于设置签名秘钥
                .signWith(SignatureAlgorithm.HS256,"itcast");
        System.out.println(jwtBuilder.compact());
    }
}

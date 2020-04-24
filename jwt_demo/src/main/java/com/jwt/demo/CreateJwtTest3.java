package com.jwt.demo;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.util.Date;
import java.util.Map;

/**
 * @author haoyang
 * @Classname CreateJwtTest3
 * @Description 自定义Claims
 * @Date 2020/4/16 0016 15:39
 * @Created by Administrator
 */
public class CreateJwtTest3 {
    public static void main(String[] args) {
        JwtBuilder claim = Jwts.builder().setId("3").setSubject("杨大大").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "itcast")
                .claim("year", 1994)
                .claim("sex", "男");
        System.out.println(claim.compact());

    }
}

package com.jwt.demo;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author haoyang
 * @Classname CreateJwtTest2
 * @Description token过期设置
 * @Date 2020/4/16 0016 15:31
 * @Created by Administrator
 */
public class CreateJwtTest2 {
    public static void main(String[] args) {
        //为了方便测试,我们将过期时间设置为1分钟
        long l = System.currentTimeMillis();
        l += 1000 * 60;
        JwtBuilder jwtBuilder = Jwts.builder().setId("2").setSubject("杨大大").setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "itcast").setExpiration(new Date(l));
        System.out.println(jwtBuilder.compact());
    }
}

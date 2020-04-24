package com.jwt.demo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * @author haoyang
 * @Classname ParseJwtTest
 * @Description 验证Token
 * @Date 2020/4/16 0016 15:25
 * @Created by Administrator
 */
public class ParseJwtTest {
    public static void main(String[] args) {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIzIiwic3ViIjoi5p2o5aSn5aSnIiwiaWF0IjoxNTg3MDIzMTI4LCJ5ZWFyIjoxOTk0LCJzZXgiOiLnlLcifQ.8XtoSRfD-25YYVLzBEyabPeaWAfq05AEKPcgcn6eQFQ";
        Claims claims = Jwts.parser()
                //私钥
                .setSigningKey("itcast")
                //解密对应的token
                .parseClaimsJws(token)
                .getBody();
        System.out.println("id = " + claims.getId());
        System.out.println("subject = " + claims.getSubject());
        System.out.println("issuedAt = " + claims.getIssuedAt());
        System.out.println("year = " + claims.get("year"));
        System.out.println("sex = " + claims.get("sex"));
    }
}

package com.tensquare.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;

/**
 * @author haoyang
 * @Classname JwtUtil
 * @Description JWTtoken工具类
 * @Date 2020/4/16 0016 15:47
 * @Created by Administrator
 */
@ConfigurationProperties("jwt.config")
public class JwtUtil {

    //秘钥
    private String key;

    //过期时间
    private long ttl;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getTtl() {
        return ttl;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }

    /**
     * 生成JWT
     * @param id
     * @param subject
     * @param role
     * @return
     */
    public String createJWT(String id, String subject, String role) {
        long l = System.currentTimeMillis();
        Date date1 = new Date(l);
        JwtBuilder jwtBuilder = Jwts.builder().setId(id).setSubject(subject).setIssuedAt(date1).signWith(SignatureAlgorithm.HS256, key)
                .claim("role", role);
        //生成对应的过期时间
        if (ttl > 0){
            jwtBuilder.setExpiration( new Date( l + ttl));
        }
        return jwtBuilder.compact();
    }

    /**
     * 解析token
     *
     * @param jwtStr token字符串
     * @return
     */
    public Claims parseJWT(String jwtStr){
        return Jwts.parser().setSigningKey(key).parseClaimsJws(jwtStr).getBody();
    }
}

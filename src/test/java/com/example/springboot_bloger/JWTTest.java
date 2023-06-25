package com.example.springboot_bloger;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import jdk.nashorn.internal.objects.NativeDate;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.HashMap;

public class JWTTest {

//    /**
//     * 获取令牌
//     */
    @Test
    void contextLoads(){
        HashMap<String,Object> map = new HashMap<>();
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.HOUR,4);
        String token = JWT.create()
                .withHeader(map)    //header
                .withClaim("userId",21)     //payload
                .withClaim("username","xiaocao")
                .withExpiresAt(instance.getTime())        //指定令牌过期实践
                .sign(Algorithm.HMAC256("!Q@fjaeoif"));     //签名

        System.out.println(token);
    }
//
//    /**
//     * 验证令牌
//     */
    @Test
    void Test1(){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("!Q@fjaeoif")).build();
        try{
            DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NzYwNDk5MDIsInVzZXJJZCI6MjEsInVzZXJuYW1lIjoieGlhb2NhbyJ9.3gWUBjaNktSh5GwRcP02HiU04Abc2kWgErYZji4973M");
            System.out.println(verify.getClaim("userId").asInt());
            System.out.println(verify.getClaim("username").asString());
            System.out.println("过期时间" + verify.getExpiresAt());
        }catch (Exception e) {
            System.out.println("token无效");
        }


    }
}

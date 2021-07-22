package cn.com.jspdi.demo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

//@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        HashMap<String, Object> map = new HashMap<>();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.SECOND, 500);

        String token = JWT.create()
                .withHeader(map)
                .withClaim("userID", "yyy")
                .withClaim("userName", "杨祎玥")
                .withClaim("time", new Date()).
                        withExpiresAt(c.getTime())
                .sign(Algorithm.HMAC256("weqeqr1"));
        System.out.println(token);
    }

    @Test
    public void test() {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("weqeqr1")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0aW1lIjoxNjI2OTUzNTI0LCJ1c2VyTmFtZSI6IuadqOeljueOpSIsImV4cCI6MTYyNjk1NDAyNCwidXNlcklEIjoieXl5In0.S2lzty7vTofhb47CaoIiL-4oKt65lZ-CO4AzTPUoM7k");
        System.out.println(decodedJWT.getClaims());
        System.out.println(decodedJWT.getClaim("userID"));
    }

}

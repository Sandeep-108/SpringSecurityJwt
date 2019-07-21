package com.security.assignment.security;

import org.springframework.stereotype.Component;

import com.security.assignment.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {


    private String secret = "secret";

    public JwtUser validate(String token) {

        JwtUser jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new JwtUser();

            jwtUser.setMobileNo(body.getSubject());
            jwtUser.setId(Long.parseLong((String) body.get("userId")));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return jwtUser;
    }
}
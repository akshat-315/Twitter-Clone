package com.project.twitterclone.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;

import javax.crypto.SecretKey;
import java.util.Date;

@Configuration
public class JwtProvider {

    SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());

    public String generateToken(Authentication auth){
        String jwt = Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+86400000))
                .claim("email", auth.getName())
                .signWith(key)
                .compact();

        return jwt;
    }

    public String getEmailFromToken(String jwt){
        jwt = jwt.substring(7);

        Claims claims = Jwts.parser()
                .verifyWith(key)
                .build().
                parseSignedClaims(jwt)
                .getBody();

        String email = String.valueOf(claims.get("email"));

        return email;
    }
}

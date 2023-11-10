package com.msansar.wordmemorization.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msansar.wordmemorization.model.Role;
import com.msansar.wordmemorization.model.User;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

@Component
public class TokenService {
    private static final String secretkey = "secretkey";
    private static Algorithm getAlgorithm(){
        return Algorithm.HMAC256(secretkey);
    }
    public static String createToken(User user){
        List<String> stringRoles = user.getRoles().stream().map(role -> role.name()).toList();
        return JWT.create()
                .withSubject(user.getUsername()) // kullanıcının primary şeyi
                .withExpiresAt(Date.from(Instant.now().plus(15, ChronoUnit.MINUTES)))
                .withIssuer("www.ms.com") // Bunu kim yapmış nerede yapmış
                .withClaim("roles", stringRoles) // TODO: düzelt
                .sign(getAlgorithm());
    }

    public static DecodedJWT verifyToken(String token){
        if(token == null){
            throw new RuntimeException("Token süresi dolmuş ya da hatalı!");
        }
        String onlyToken = token.split("Bearer ")[1];
        JWTVerifier verifier = JWT.require(getAlgorithm()).build();
        return verifier.verify(onlyToken);
    }
    public static boolean isTokenValid(String token){
        if(getUsernameFromToken(token) != null && isTokenExpired(token)){
            return true;
        }
        return false;
    }
    public static String getUsernameFromToken(String token){
        return verifyToken(token).getSubject();
    }

    private static boolean isTokenExpired(String token){
        return verifyToken(token).getExpiresAt().before(new Date(System.currentTimeMillis()));
    }



}

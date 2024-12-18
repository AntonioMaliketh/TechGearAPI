package com.maliketh.TechGearAPI.infrastructure;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.maliketh.TechGearAPI.users.User;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {
        try {
    var algorithm = Algorithm.HMAC256(secret);
    return JWT.create()
        .withIssuer("hardwares_api")
        .withSubject(user.getLogin())
        .withExpiresAt(dateExpire())
        .sign(algorithm);
} catch (JWTCreationException exception){
    throw new RuntimeException("error generating token", exception);
}
    }

    public String getSubject(String TokenJWT) {
        try {
        var algorithm = Algorithm.HMAC256(secret);
        return JWT.require(algorithm)
        .withIssuer("hardwares_api")
        .build()
        .verify(TokenJWT)
        .getSubject();
        
} catch (JWTVerificationException exception){
    throw new RuntimeException("Invalid or Expired Token");
}
    }

    private Instant dateExpire() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}

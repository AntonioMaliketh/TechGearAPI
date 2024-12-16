package com.maliketh.TechGearAPI.infrastructure;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.maliketh.TechGearAPI.users.User;

@Service
public class TokenService {

    public String generateToken(User user) {
        try {
    var algorithm = Algorithm.HMAC256("batata");
    return JWT.create()
        .withIssuer("hardwares_api")
        .withSubject(user.getLogin())
        .withExpiresAt(dateExpire())
        .sign(algorithm);
} catch (JWTCreationException exception){
    throw new RuntimeException("error generating token", exception);
}
    }

    private Instant dateExpire() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}

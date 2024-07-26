//package com.pokemon_team_builder.backend.service;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.pokemon_team_builder.backend.model.LocalUser;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//
//@Service
//public class JWTService {
//
//    private static final String USERNAME_KEY = "USERNAME";
//
//    @Value("${jwt.algorithm.key}")
//    private String algorithmKey;
//
//    @Value("${jwt.issuer}")
//    private String issuer;
//
//    @Value("${jwt.expiryInSeconds}")
//    private int expiryInSeconds;
//
//    private Algorithm algorithm;
//
//    @PostConstruct
//    public void postConstruct(){
//        algorithm = Algorithm.HMAC256(algorithmKey);
//    }
//
//    public String generateJWT(LocalUser user){
//        return JWT.create()
//                .withClaim(USERNAME_KEY, user.getUsername())
//                .withExpiresAt(new Date(System.currentTimeMillis() + (1000L * expiryInSeconds)))
//                .withIssuer(issuer)
//                .sign(algorithm);
//
//    }
//
//    public String getUsername(String token) {
//        return JWT.decode(token).getClaim(USERNAME_KEY).asString();
//    }
//}

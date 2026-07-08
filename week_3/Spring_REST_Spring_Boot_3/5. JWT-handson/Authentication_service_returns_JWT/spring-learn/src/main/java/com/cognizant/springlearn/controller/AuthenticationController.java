package com.cognizant.springlearn.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@RestController
public class AuthenticationController {

    // Secret key must be at least 32 bytes for HS256
    private static final String SECRET =
            "MySecretKeyForJWTAuthentication123456789";

    @GetMapping("/")
    public String home() {
        return "Welcome to Spring Learn REST API";
    }

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader("Authorization") String authHeader) {

        Map<String, String> response = new HashMap<>();

        String user = getUser(authHeader);

        String token = generateJwt(user);

        response.put("token", token);

        return response;
    }

    private String getUser(String authHeader) {

        String encodedCredentials = authHeader.substring("Basic ".length());

        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);

        String decodedString = new String(decodedBytes);

        return decodedString.split(":")[0];
    }

    private String generateJwt(String user) {

        SecretKey key = Keys.hmacShaKeyFor(
                SECRET.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .setSubject(user)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1200000))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
package com.springbootproject.ProductCustomerService.config;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.Key;
import java.time.Instant;
import java.util.Date;

@Service
@Slf4j
public class JwtService {


    private static final String SECRET = "2A3896817DC8FD6EFB98D14D5369E2D0C64C3ED425D46A0A38C0B7F049E90AE998D6EEB3FBF41A30508A964AE5152A221054110A0FC92215B16BBF9CD8143088";
    private static final long VALIDITY = TimeUnit.MINUTES.toMillis(30);

    /**
     * for genarate token
     */
    public String genarateJwtToken(UserDetails userDetails) {
        Map<String, String> claims = new HashMap<>();

        log.info("userDetails:::::::======={}", userDetails.toString());
        return Jwts.builder()
                // .claims(claims)
                .subject(userDetails.getUsername())
                .issuedAt(Date.from(Instant.now()))
                .expiration(Date.from(Instant.now().plusMillis(VALIDITY)))
                .signWith(getSignKey())
                .compact();
    }

    private static Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public static String getSubjectFromToken(String jwtToken) {
        log.info("getSubjectFrom token method enetered with token  ::::{}", jwtToken);
        Claims claims = getClaims(jwtToken);
        return claims.getSubject();

    }

    public static Claims getClaims(String jwtToken) {
        log.info("getClaims token method enetered with token  ::::{}", jwtToken);
        return Jwts.parser()
                .verifyWith((SecretKey) getSignKey())
                .build()
                .parseSignedClaims(jwtToken)
                .getPayload();

    }

    public static boolean isTokenValid(String jwtToken) {
        log.info("isTokenValid  method enetered with token  ::::{}", jwtToken);
        Claims claims = getClaims(jwtToken);

        return claims.getExpiration().after(Date.from(Instant.now()));

    }

}

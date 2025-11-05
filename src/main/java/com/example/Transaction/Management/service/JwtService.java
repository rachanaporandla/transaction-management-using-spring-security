package com.example.Transaction.Management.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service

public class JwtService {

    private static final String SECRET_KEY = "mysecretkeyforjwtauthentication12345";
    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    public String generateToken(String username)
    {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
    public boolean validateToken(String token)
    {
        try
         {
            Claims claims = extractAllClaims(token);
            return claims.getExpiration().after(new Date());
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public String extractUsername(String token)
    {
        return extractClaim(token, Claims::getSubject);
    }

    private Claims extractAllClaims(String token)
    {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
}

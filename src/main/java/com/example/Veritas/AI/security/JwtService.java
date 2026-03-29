package com.example.Veritas.AI.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
@Service
public class JwtService {

    private static final String SECRET="gyuvuvyuvcyvjhvrryxychgvjhcfxcjvjhvcytchgvjhctyytcxrtx132797688";
    //Map<String,Object> claims=new HashMap<>();
    //generating token here
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+60*60*30))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignKey(){
        byte[]keyBytes= Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public String extractUsername(String token){
        return extractAllClaims(token).getSubject();
    }

    //validate token &&// token expiring checking

//public boolean isTokenValid(String token,String username){
//    final String extractedUsername=extractUsername(token);
//        return extractedUsername.equals(username)&&!isTokenExpired(token);
//}

    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    //    public boolean validateToken(String token){
//
//        return extractedUsername.equals(username)&& !isTokenValid(username);
//    }
    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getSignKey()).build()
                .parseClaimsJws(token).getBody();
    }


    public boolean validateToken(String token, UserDetails userdetails) {
        final String username=extractUsername(token);
        return (username.equals(userdetails.getUsername())&&!isTokenExpired(token));
    }
}

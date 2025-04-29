package com.sofiadev.Offispace.configuration;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

   private SecretKey key;

   @PostConstruct
   public void init(){
       byte[] keyBytes = Decoders.BASE64.decode(secretKey);
       this.key = Keys.hmacShaKeyFor(keyBytes);
   }

   //creamos token
    public String generateToken(UserDetails userDetails){
        return Jwts
                .builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(key, Jwts.SIG.HS256)
                .compact();
    }

    //Validamos si el token es correcto
    public boolean isTokenValid(String token, String email){
        try {
            var claims = Jwts
                    .parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            String extractedEmail = claims.getSubject();
            Date expiration = claims.getExpiration();

            return (extractedEmail.equals(email) && !expiration.before(new Date()));
        } catch (Exception e) {
            return false;
        }
    }

    public String extractUsername(String token) {
       return Jwts.parser()
               .verifyWith(key)
               .build()
               .parseSignedClaims(token)
               .getPayload()
               .getSubject();
    }

}

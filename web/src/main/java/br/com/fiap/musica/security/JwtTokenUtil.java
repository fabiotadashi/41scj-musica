package br.com.fiap.musica.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {

    @Value("${fiap.token.secret}")
    private String secret;

    @Value("${fiap.token.expireInSeconds}")
    private int expireInSeconds;

    public String generateToken(String nome){
        Map<String, Object> claims = new HashMap<>();
        Date dataCriacao = getDateFromLocalDateTime(LocalDateTime.now());
        Date dataExpiracao = getDateFromLocalDateTime(LocalDateTime.now().plusSeconds(expireInSeconds));
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(dataCriacao)
                .setExpiration(dataExpiracao)
                .setSubject(nome)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String getUserFromToken(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token.replace("Bearer ", ""))
                .getBody();
        return claims.getSubject();
    }

    private Date getDateFromLocalDateTime(LocalDateTime now) {
        return Date.from(now.toInstant(OffsetDateTime.now().getOffset()));
    }

}

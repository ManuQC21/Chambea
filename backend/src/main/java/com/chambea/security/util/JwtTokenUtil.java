package com.chambea.security.util;

import com.chambea.model.Usuario;
import com.chambea.security.UserDetailsImpl;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class JwtTokenUtil implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(JwtTokenUtil.class);

    @Value("${chambea.jwtSecret}")
    private String jwtSecret;

    @Value("${chambea.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String createToken(Usuario usuario){
        return Jwts.builder()
                .setSubject(String.format("%s,%s", usuario.getIdUsuario(), usuario.getNombreUsuario()))
                .setIssuer(";)")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String createToken(UserDetailsImpl usuario){
        return Jwts.builder()
                .setSubject(String.format("%s,%s", usuario.getId(), usuario.getUsername()))
                .setIssuer(";)")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getId(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject().split(",")[0];
    }

    public String getUsername(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject().split(",")[1];
    }

    public Date getExpirationDateTime(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
        return claims.getExpiration();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException e){
            log.error("Invalid JWT signature");
        } catch (MalformedJwtException e){
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException e){
            log.error("JWT is expired");
        } catch (UnsupportedJwtException e){
            log.error("JWT unsupported");
        } catch (IllegalArgumentException e){
            log.error("JWT is empty");
        }

        return false;
    }
}

package com.maximo.esm.apimcr.security.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {

    static final String CLAIM_KEY_USERNAME = "sub";
    static final String CLAIM_KEY_ROLE = "role";
    static final String CLAIM_KEY_CREATED = "created";

    private SecurityConstants constants;

    public String getUsernameFromToken(String token){
        String username;
        try {
            //Clains - declarações - determina a politica de segurança.
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e){
            username = null;}

        return username;
    }
    public Date getExpirationDateFromToken(String token){
        Date expiration;
        try {
            Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        }catch (Exception e){
            expiration = null;
        }
        return expiration;
    }
    // Cria um novo token (refresh).

    public String refreshToken(String token){
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put(CLAIM_KEY_CREATED,new Date());
            refreshedToken = gerarToken(claims);
        }catch (Exception e){
            refreshedToken = null;
        }
        return refreshedToken;
    }
    public boolean tokenValido(String token){
        return !tokenExpirado(token);
    }
    public String obterToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        userDetails.getAuthorities().forEach(authority -> claims.put(CLAIM_KEY_ROLE, authority.getAuthority()));
        claims.put(CLAIM_KEY_CREATED, new Date());
        return gerarToken(claims);
    }

    private Claims getClaimsFromToken(String token){
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(constants.SECRET)
                    .parseClaimsJws(token).getBody();
        } catch (Exception e){
            claims = null;
        } return claims;
    }
    private Date gerarDataExpiracao(){
        return new Date(System.currentTimeMillis() + constants.EXPIRATION_TIME);
    }
    private boolean tokenExpirado(String token){
        Date dataExpiracao = this.getExpirationDateFromToken(token);
        if (dataExpiracao == null){
            return false;
        } return dataExpiracao.before(new Date());
    }

    private String gerarToken(Map<String, Object> claims){
        return Jwts.builder()
                .setIssuer("apimcr")
                .setClaims(claims)
                .setExpiration(gerarDataExpiracao())
                .signWith(SignatureAlgorithm.HS512, constants.SECRET)
                .compact();
    }
}

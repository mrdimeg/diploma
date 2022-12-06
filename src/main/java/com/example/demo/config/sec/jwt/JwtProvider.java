package com.example.demo.config.sec.jwt;

import com.example.demo.entity.Role;
import com.google.gson.Gson;
import io.jsonwebtoken.*;
import io.jsonwebtoken.gson.io.GsonSerializer;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtProvider {
    @Value("${security.token.jwt.secret}")
    private String jwtSecret;
    @Value("${security.token.jwt.expired}")
    private long jwtExpirationTimeInMilliseconds;
    private final UserDetailsService userDetailsService;

    public JwtProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostConstruct
    protected void init() {
        jwtSecret = Base64.getEncoder().encodeToString(jwtSecret.getBytes());
    }

    public String generateJWT(String username, Set<Role> roles){
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", getUserRoleNamesFromJWT(roles));
        Date jwtCreationDate = new Date();
        Date jwtExpirationDate = new Date(jwtCreationDate.getTime() + jwtExpirationTimeInMilliseconds);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(jwtCreationDate)
                .setExpiration(jwtExpirationDate)
                .signWith(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                .serializeToJsonWith(new GsonSerializer<>(new Gson()))
                .compact();
    }

    public Authentication getAuthentication(String jsonWebToken) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(getUsernameFromJWT(jsonWebToken));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private String getUsernameFromJWT(String jsonWebToken){
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                .build()
                .parseClaimsJws(jsonWebToken)
                .getBody()
                .getSubject();
    }

    public String getJWTFromRequest(HttpServletRequest req) {
        String authorizationHeader = req.getHeader("Authorization");
        String jsonWebToken = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
            jsonWebToken = authorizationHeader.substring(7);
        }
        return jsonWebToken;
    }

    private List<String> getUserRoleNamesFromJWT(Set<Role> roles) {
        return roles.stream()
                .map(Role::getName)
                .collect(Collectors.toList());
    }

    public boolean isValidJWT(String jwtToken) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                    .build()
                    .parseClaimsJws(jwtToken);
            return claims.getBody().getExpiration().after(new Date());
        } catch (RuntimeException exception) {
            return false;
        }
    }
}

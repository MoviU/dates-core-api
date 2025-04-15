package com.dates.core_api.service;

import com.dates.core_api.config.JwtConfig;
import com.dates.core_api.model.entity.User;
import com.dates.core_api.security.Role;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {
    private final JwtConfig jwtConfig;

    @Override
    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(getUsernameFromUser(user))
                .claim("roles", List.of(new SimpleGrantedAuthority(Role.USER.getSecurityName())))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtConfig.getExpirationInMilliseconds()))
                .signWith(Keys.hmacShaKeyFor(jwtConfig.getSecret().getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    private String getUsernameFromUser(User user) {
        if (!user.getPhoneNumber().isEmpty()) return user.getPhoneNumber();

        return user.getPhoneNumber();
    }
}

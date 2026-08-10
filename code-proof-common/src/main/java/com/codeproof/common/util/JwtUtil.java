package com.codeproof.common.util;

import com.codeproof.common.properties.JwtProperties;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.nio.charset.StandardCharsets;

/**
 * @author Liu Yuke
 * @date 2026/8/10
 */
@RequiredArgsConstructor
@Component
public class JwtUtil {
    private final JwtProperties jwtProperties;

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(jwtProperties.getSecret().getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(Long userId, String username) {
        return Jwts.builder()
                .subject(username)
                .claim("userId", userId)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + jwtProperties.getExpiration()))
                .signWith(getSigningKey())
                .compact();
    }

    public Long getUserIdFromToken(String token) {
        // TODO: 获取用户 ID
        return null;
    }

    public String getUsernameFromToken(String token) {
        // TODO: 获取用户名
        return null;
    }

    public boolean validateToken(String token) {
        // TODO: 验证令牌
        return true;
    }
}

package com.codeproof.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * JWT 配置属性
 * @author Liu Yuke
 * @date 2026/8/10
 */
@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    /**
     * JWT密钥(256位以上)
     */
    private String secret = "code-proof-secret-key-must-be-at-least-256-bits-long";

    /**
     * JWT过期时间(毫秒), 默认1天
     */
    private Long expiration = 86400000L;
}

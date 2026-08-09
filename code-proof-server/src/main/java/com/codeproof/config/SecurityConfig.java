package com.codeproof.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Liu Yuke
 * @date 2026/8/9
 */
@Configuration
public class SecurityConfig {
    /**
     * 放行白名单
     */
    public static final String[] WHITE_LIST = {
            "/auth/**",
            "/test/**",
            "/hello"
    };

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth.requestMatchers(WHITE_LIST).permitAll()
                        .anyRequest().authenticated());
        return http.build();
    }
}

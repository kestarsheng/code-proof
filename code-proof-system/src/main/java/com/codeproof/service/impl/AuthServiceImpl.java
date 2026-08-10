package com.codeproof.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codeproof.dto.RegisterRequest;
import com.codeproof.entity.User;
import com.codeproof.mapper.UserMapper;
import com.codeproof.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Liu Yuke
 * @date 2026/8/9
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl  extends ServiceImpl<UserMapper, User> implements AuthService {

    private final PasswordEncoder passwordEncoder;

    /**
     * 注册
     *
     * @param request 注册请求DTO
     */
    @Override
    public void register(RegisterRequest request) {
        //1.校验用户名是否存在
        LambdaQueryWrapper<User> usernameQueryWrapper = Wrappers.<User>lambdaQuery()
                .eq(User::getUsername, request.getUsername());
        if (this.count(usernameQueryWrapper) > 0) {
            log.warn("用户名已存在：{}", request.getUsername());
            throw new RuntimeException("用户名已存在");
        }
        //2.校验邮箱是否存在
        LambdaQueryWrapper<User> emailQueryWrapper = Wrappers.<User>lambdaQuery()
                .eq(User::getEmail, request.getEmail());
        if (this.count(emailQueryWrapper) > 0) {
            log.warn("邮箱已存在：{}", request.getEmail());
            throw new RuntimeException("邮箱已存在");
        }
        //3.保存用户
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))  // ← 加密后再存
                .email(request.getEmail())
                .status(1)
                .build();
        this.save(user);
        log.info("用户注册成功：{}", user.getUsername());

    }
}

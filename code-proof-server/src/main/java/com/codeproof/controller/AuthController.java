package com.codeproof.controller;

import com.codeproof.common.result.Result;
import com.codeproof.dto.LoginRequest;
import com.codeproof.mapper.UserMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户认证
 *
 * @author Liu Yuke
 * @date 2026/8/7
 */
@RestController
public class AuthController {
    @Autowired
    private  UserMapper userMapper;

    @PostMapping("/auth/login")
    public Result<String> login(@Valid @RequestBody LoginRequest loginRequest) {
        return Result.success("登录成功，用户："+ loginRequest.getUsername());
    }

    @GetMapping("/test/db")
    public Result<String> testDb() {
        long count = userMapper.selectCount(null);
        return Result.success("数据库连接成功，当前用户数: " + count);
    }
}

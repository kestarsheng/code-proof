package com.codeproof.controller;

import com.codeproof.common.result.Result;
import com.codeproof.dto.LoginRequest;
import jakarta.validation.Valid;
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
    @PostMapping("/auth/login")
    public Result<String> login(@Valid @RequestBody LoginRequest loginRequest) {
        return Result.success("登录成功，用户："+ loginRequest.getUsername());
    }
}

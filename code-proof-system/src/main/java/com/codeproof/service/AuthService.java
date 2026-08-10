package com.codeproof.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.codeproof.dto.RegisterRequest;
import com.codeproof.entity.User;

/**
 * 认证服务接口
 * @author Liu Yuke
 * @date 2026/8/9
 */
public interface AuthService extends IService<User> {
    /**
     * 注册
     * @param request 注册请求DTO
     */
    void register(RegisterRequest request);
}

package com.codeproof.common.result;

import lombok.Getter;

/**
 * 响应码枚举
 * 统一管理所有业务状态码和提示信息
 *
 * @author Liu Yuke
 * @date 2026/8/7
 */
@Getter
public enum ResultCode {

    // ========== 通用状态码 ==========
    SUCCESS(200, "操作成功"),
    ERROR(500, "系统发生错误，请稍后再试"),

    // ========== 客户端错误 4xx ==========
    BAD_REQUEST(400, "请求参数错误"),
    UNAUTHORIZED(401, "未登录或登录已过期"),
    FORBIDDEN(403, "没有权限访问该资源"),
    NOT_FOUND(404, "请求资源不存在"),

    // ========== 业务错误 ==========
    USER_NOT_EXIST(1001, "用户不存在"),
    USER_PASSWORD_ERROR(1002, "用户名或密码错误"),
    USER_ALREADY_EXIST(1003, "用户已存在");

    private final Integer code;
    private final String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}

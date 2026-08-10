package com.codeproof.common.exception;

import com.codeproof.common.result.ResultCode;
import lombok.Getter;

/**
 * 业务异常
 * 用于用户输入错误、业务规则校验失败等场景
 * @author Liu Yuke
 * @date 2026/08/10
 */
@Getter
public class BusinessException extends RuntimeException {

    private final ResultCode resultCode;

    public BusinessException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public BusinessException(ResultCode resultCode, String message) {
        super(message);
        this.resultCode = resultCode;
    }
}
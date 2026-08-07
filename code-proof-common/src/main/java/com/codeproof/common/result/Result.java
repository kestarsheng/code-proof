package com.codeproof.common.result;

import java.io.Serializable;

/**
 * 统一响应结果
 *
 * @author Liu Yuke
 * @date 2026/8/6
 */
public class Result<T> implements Serializable {

    private Integer code;
    private String message;
    private T data;

    public Result() {
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    //成功响应
    public static <T> Result<T> success() {
        return new Result<>(
                ResultCode.SUCCESS.getCode(),
                ResultCode.SUCCESS.getMessage(),
                null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(
                ResultCode.SUCCESS.getCode(),
                ResultCode.SUCCESS.getMessage(),
                data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(
                ResultCode.SUCCESS.getCode(),
                message,
                data);
    }

    //失败响应
    public static <T> Result<T> error() {
        return new Result<>(
                ResultCode.ERROR.getCode(),
                ResultCode.ERROR.getMessage(),
                null);
    }

    public static <T> Result<T> error(String message) {
        return new Result<>(
                ResultCode.ERROR.getCode(),
                message,
                null);
    }

    public static <T> Result<T> error(ResultCode resultCode, String message) {
        return new Result<>(
                resultCode.getCode(),
                message,
                null);
    }

    public static <T> Result<T> error(Integer code, String message) {
        return new Result<>(
                code,
                message,
                null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

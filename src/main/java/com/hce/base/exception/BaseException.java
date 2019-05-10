package com.hce.base.exception;

import com.hce.exception.ResultType;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
    /**
     * 异常对应的错误类型
     */
    private ResultType resultType;

    /**
     * 默认是系统异常
     */
    public BaseException() {
        this.resultType = ResultType.SYSTEM_ERROR;
    }

    public BaseException(ResultType resultType) {
        this.resultType = resultType;
    }

    public BaseException(ResultType resultType, String message) {
        super(message);
        this.resultType = resultType;
    }

    public BaseException(ResultType resultType, String message, Throwable cause) {
        super(message, cause);
        this.resultType = resultType;
    }
}

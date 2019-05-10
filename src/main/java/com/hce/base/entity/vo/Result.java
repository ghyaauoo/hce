package com.hce.base.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.hce.base.exception.BaseException;
import com.hce.exception.ResultType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.time.Instant;
import java.time.ZonedDateTime;

@ApiModel(description = "rest请求的返回模型，所有rest正常都返回该类的对象")
@Getter
public class Result<T> {

    public static final String SUCCESSFUL_CODE = "100";
    public static final String SUCCESSFUL_MESG = "处理成功";

    @ApiModelProperty(value = "处理结果code", required = true)
    private String code;
    @ApiModelProperty(value = "处理结果描述信息")
    private String mesg;
    @ApiModelProperty(value = "请求结果生成时间戳")
    private Instant timestamp;
    @ApiModelProperty(value = "处理结果数据信息")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public Result() {
        this.timestamp = ZonedDateTime.now().toInstant();
    }

    /**
     * @param resultType
     */
    public Result(ResultType resultType) {
        this.code = resultType.getCode();
        this.mesg = resultType.getMesg();
        this.timestamp = ZonedDateTime.now().toInstant();
    }

    /**
     * @param resultType
     * @param data
     */
    public Result(ResultType resultType, T data) {
        this(resultType);
        this.data = data;
    }

    /**
     * 内部使用，用于构造成功的结果
     *
     * @param code
     * @param mesg
     * @param data
     */
    private Result(String code, String mesg, T data) {
        this.code = code;
        this.mesg = mesg;
        this.data = data;
        this.timestamp = ZonedDateTime.now().toInstant();
    }

    /**
     * 快速创建成功结果并返回结果数据
     *
     * @param data
     * @return Result
     */
    public static Result success(Object data) {
        return new Result<>(SUCCESSFUL_CODE, SUCCESSFUL_MESG, data);
    }

    /**
     * 快速创建成功结果
     *
     * @return Result
     */
    public static Result success() {
        return success(null);
    }

    /**
     * 系统成功并返回结果数据
     *
     * @param resultType
     * @param data
     * @return Result
     */
    public static Result success(ResultType resultType, Object data) {
        return new Result<>(resultType, data);
    }

    /**
     * 系统成功并返回结果数据
     *
     * @param resultType
     * @return Result
     */
    public static Result success(ResultType resultType) {
        return Result.fail(resultType, null);
    }

    /**
     * 系统异常类没有返回数据
     *
     * @return Result
     */
    public static Result fail() {
        return new Result(ResultType.SYSTEM_ERROR);
    }

    /**
     * 系统异常类没有返回数据
     *
     * @param baseException
     * @return Result
     */
    public static Result fail(BaseException baseException) {
        return fail(baseException, null);
    }

    /**
     * 系统异常类并返回结果数据
     *
     * @param data
     * @return Result
     */
    public static Result fail(BaseException baseException, Object data) {
        return new Result<>(baseException.getResultType(), data);
    }

    /**
     * 系统异常类并返回结果数据
     *
     * @param resultType
     * @param data
     * @return Result
     */
    public static Result fail(ResultType resultType, Object data) {
        return new Result<>(resultType, data);
    }

    /**
     * 系统异常类并返回结果数据
     *
     * @param resultType
     * @return Result
     */
    public static Result fail(ResultType resultType) {
        return Result.fail(resultType, null);
    }

    /**
     * 系统异常类并返回结果数据
     *
     * @param data
     * @return Result
     */
    public static Result fail(Object data) {
        return new Result<>(ResultType.SYSTEM_ERROR, data);
    }


    /**
     * 成功code=000000
     *
     * @return true/false
     */
    @JsonIgnore
    public boolean isSuccess() {
        return SUCCESSFUL_CODE.equals(this.code);
    }

    /**
     * 失败
     *
     * @return true/false
     */
    @JsonIgnore
    public boolean isFail() {
        return !isSuccess();
    }
}

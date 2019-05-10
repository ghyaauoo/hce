package com.hce.exception;

import lombok.Getter;

@Getter
public enum ResultType {

    LOGIN_SUCCESS("100", "登陆成功"),
    LOGIN_FAIL_INVALID_PASSWORD("101", "密码错误"),
    LOGIN_FAIL_USER_NOT_EXIST("102", "用户名不存在"),
    LOGIN_FAILURE("103", "登陆失败"),

    REGISTER_SUCCESS("100", "注册成功"),
    REGISTER_FAIL_USERNAME_EXIST("101", "用户名已存在"),
    REGISTER_FAILURE("102", "注册失败"),

    CHGPWD_SUCCESS("100", "修改成功"),
    CHGPWD_FAIL_WRONG_OLDPWD("101", "原密码错误"),
    CHGPWD_FAILURE("102", "修改失败"),

    CHARGE_SUCCESS("100", "充值成功"),
    CHARGE_FAILURE("101", "充值失败"),

    QUERY_SUCCESS("100", "查询成功"),
    QUERY_FAILURE("101", "查询失败"),

    SYSTEM_ERROR("-1", "系统异常"),

    SYSTEM_BUSY("000001", "系统繁忙,请稍候再试"),
    SYSTEM_NO_PERMISSION("000002", "无权限"),

    GATEWAY_NOT_FOUND_SERVICE("010404", "服务未找到"),
    GATEWAY_ERROR("010500", "网关异常"),
    GATEWAY_CONNECT_TIME_OUT("010002", "网关超时"),

    ARGUMENT_NOT_VALID("020000", "请求参数校验不通过"),
    UPLOAD_FILE_SIZE_LIMIT("020001", "上传文件大小超过限制");

    /**
     * 错误类型码
     */
    private String code;
    /**
     * 错误类型描述信息
     */
    private String mesg;

    ResultType(String code, String mesg) {
        this.code = code;
        this.mesg = mesg;
    }
}

package com.hce.rest;

import com.hce.base.entity.vo.Result;
import com.hce.entity.form.UserChgForm;
import com.hce.entity.form.UserForm;
import com.hce.entity.form.UserQueryForm;
import com.hce.entity.param.UserQueryParam;
import com.hce.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Auther: 高浩宇
 * @Desc:
 * @Date: Created in 2019/5/9 03:53
 * @modified by:
 */
@RestController
@RequestMapping("/user")
@Api("user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "登陆接口", notes = "登陆接口")
    @ApiImplicitParam(name = "userQueryForm", value = "查询用户form表单", required = true, dataType = "UserQueryForm")
    @PostMapping(value = "/login")
    public Result login(@Valid @RequestBody UserQueryForm userQueryForm) {
        return userService.login(userQueryForm.toParam(UserQueryParam.class));
    }

    @ApiOperation(value = "注册接口", notes = "注册接口")
    @ApiImplicitParam(name = "userForm", value = "注册用户form表单", required = true, dataType = "UserForm")
    @PostMapping(value = "/register")
    public Result register(@Valid @RequestBody UserForm userForm) {
        return userService.register(userForm);
    }

    @ApiOperation(value = "修改密码接口", notes = "修改密码接口")
    @ApiImplicitParam(name = "userChgForm", value = "修改密码用户form表单", required = true, dataType = "UserChgForm")
    @PostMapping(value = "/chgPwd")
    public Result chgPwd(@Valid @RequestBody UserChgForm userChgForm) {
        return userService.chgPwd(userChgForm);
    }
}

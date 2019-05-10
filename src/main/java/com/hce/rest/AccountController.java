package com.hce.rest;

import com.hce.base.entity.vo.Result;
import com.hce.entity.form.*;
import com.hce.entity.param.UserQueryParam;
import com.hce.service.IAccountService;
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
@RequestMapping("/account")
@Api("account")
@Slf4j
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @ApiOperation(value = "充值接口", notes = "充值接口")
    @ApiImplicitParam(name = "accountChargeForm", value = "充值账户form表单", required = true, dataType = "AccountChargeForm")
    @PostMapping(value = "/charge")
    public Result charge(@Valid @RequestBody AccountChargeForm accountChargeForm) {
        return accountService.charge(accountChargeForm);
    }

    @ApiOperation(value = "账户余额查询", notes = "账户余额查询")
    @ApiImplicitParam(name = "accountQueryForm", value = "账户查询form表单", required = true, dataType = "AccountQueryForm")
    @PostMapping(value = "/query")
    public Result query(@Valid @RequestBody AccountQueryForm accountQueryForm) {
        return accountService.query(accountQueryForm);
    }

}

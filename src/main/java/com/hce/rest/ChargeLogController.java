package com.hce.rest;

import com.hce.base.entity.vo.Result;
import com.hce.entity.form.AccountChargeForm;
import com.hce.entity.form.AccountQueryForm;
import com.hce.entity.form.ChargeLogQueryForm;
import com.hce.service.IAccountService;
import com.hce.service.IChargeLogService;
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
@RequestMapping("/chargeLog")
@Api("chargeLog")
@Slf4j
public class ChargeLogController {

    @Autowired
    private IChargeLogService chargeLogService;

    @ApiOperation(value = "充值记录查询", notes = "充值记录查询")
    @ApiImplicitParam(name = "chargeLogQueryForm", value = "充值记录查询form表单", required = true, dataType = "ChargeLogQueryForm")
    @PostMapping(value = "/query")
    public Result query(@Valid @RequestBody ChargeLogQueryForm chargeLogQueryForm) {
        return chargeLogService.query(chargeLogQueryForm);
    }

}

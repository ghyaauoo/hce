package com.hce.entity.form;

import com.hce.base.entity.form.BaseForm;
import com.hce.entity.po.Account;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Auther: 高浩宇
 * @Desc:
 * @Date: Created in 2019/5/9 03:14
 * @modified by:
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel
@Data
@Slf4j
public class AccountForm extends BaseForm<Account> {

    @NotNull(message = "用户编号不能为空")
    @ApiModelProperty(value = "用户编号")
    private Long userId;

    @NotEmpty(message = "账户余额不能为空")
    @ApiModelProperty(value = "账户余额")
    private String balance;
}

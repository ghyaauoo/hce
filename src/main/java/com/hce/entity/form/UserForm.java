package com.hce.entity.form;

import com.hce.base.entity.form.BaseForm;
import com.hce.entity.po.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotEmpty;

/**
 * @Auther: 高浩宇
 * @Desc:
 * @Date: Created in 2019/5/9 03:04
 * @modified by:
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel
@Data
@Slf4j
public class UserForm extends BaseForm<User> {

    @NotEmpty(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名")
    private String username;

    @NotEmpty(message = "密码不能为空")
    @ApiModelProperty(value = "密码")
    private String password;
}

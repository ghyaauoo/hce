package com.hce.entity.form;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class UserChgForm extends BaseForm<User> {

    @NotEmpty(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名")
    private String username;

    @NotEmpty(message = "旧密码不能为空")
    @ApiModelProperty(value = "旧密码")
    private String oldpwd;

    @NotEmpty(message = "新密码不能为空")
    @ApiModelProperty(value = "新密码")
    private String newpwd;

    @Override
    public User toPo(Class<User> clazz) {
        User user = new User();
        user.setUsername(this.getUsername());
        user.setPassword(this.getNewpwd());
        return user;
    }
}

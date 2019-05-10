package com.hce.entity.form;

import com.hce.base.entity.form.BaseQueryForm;
import com.hce.entity.param.UserQueryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Auther: 高浩宇
 * @Desc:
 * @Date: Created in 2019/5/9 03:56
 * @modified by:
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel
@Data
public class UserQueryForm extends BaseQueryForm<UserQueryParam> {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;
}

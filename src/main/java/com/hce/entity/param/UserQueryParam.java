package com.hce.entity.param;

import com.hce.base.entity.param.BaseParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Auther: 高浩宇
 * @Desc:
 * @Date: Created in 2019/5/9 03:20
 * @modified by:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserQueryParam extends BaseParam {

    private String username;

    private String password;

    public UserQueryParam(String username) {
        this.username = username;
    }
}

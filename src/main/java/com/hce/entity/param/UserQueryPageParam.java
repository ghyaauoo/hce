package com.hce.entity.param;

import com.hce.base.entity.param.BaseParam;
import io.swagger.annotations.ApiModelProperty;
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
public class UserQueryPageParam extends BaseParam {

    private String username;

    private String password;

    private Integer pageNum;

    private Integer pageSize;

    public UserQueryPageParam(String username) {
        this.username = username;
    }
}

package com.hce.entity.form;

import com.hce.base.entity.form.BaseQueryForm;
import com.hce.entity.param.UserQueryPageParam;
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
public class UserQueryPageForm extends BaseQueryForm<UserQueryPageParam> {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "页码")
    private Integer pageNum;

    @ApiModelProperty(value = "一页大小")
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum == null ? 0 : pageNum;
    }

    public Integer getPageSize() {
        return pageSize == null ? 10 : pageSize;
    }

    @Override
    public UserQueryPageParam toParam(Class<UserQueryPageParam> clazz) {
        UserQueryPageParam userQueryPageParam = new UserQueryPageParam();
        userQueryPageParam.setUsername(this.getUsername());
        userQueryPageParam.setPageNum(this.pageNum);
        userQueryPageParam.setPageSize(this.pageSize);
        return userQueryPageParam;
    }
}

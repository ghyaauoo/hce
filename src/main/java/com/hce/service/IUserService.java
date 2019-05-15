package com.hce.service;

import com.hce.base.entity.vo.Result;
import com.hce.entity.form.UserChgForm;
import com.hce.entity.form.UserForm;
import com.hce.entity.form.UserQueryForm;
import com.hce.entity.form.UserQueryPageForm;
import com.hce.entity.param.UserQueryParam;

/**
 * @Auther: 高浩宇
 * @Desc:
 * @Date: Created in 2019/5/9 03:45
 * @modified by:
 */
public interface IUserService {


    Result login(UserQueryParam userQueryParam);

    Result register(UserForm userForm);

    Result chgPwd(UserChgForm userChgForm);

    Result queryByPage(UserQueryPageForm userQueryPageForm);

}

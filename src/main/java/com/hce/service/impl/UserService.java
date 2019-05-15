package com.hce.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hce.base.entity.vo.Result;
import com.hce.dao.AccountMapper;
import com.hce.dao.UserMapper;
import com.hce.entity.form.UserChgForm;
import com.hce.entity.form.UserForm;
import com.hce.entity.form.UserQueryForm;
import com.hce.entity.form.UserQueryPageForm;
import com.hce.entity.param.UserQueryPageParam;
import com.hce.entity.param.UserQueryParam;
import com.hce.entity.po.Account;
import com.hce.entity.po.User;
import com.hce.entity.vo.UserVo;
import com.hce.exception.ResultType;
import com.hce.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 高浩宇
 * @Desc:
 * @Date: Created in 2019/5/9 03:46
 * @modified by:
 */
@Service
@Slf4j
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Result login(UserQueryParam userQueryParam) {
        try {
            User user = userMapper.select(userQueryParam.getUsername());
            if (user != null) {
                if (user.getPassword().equals(userQueryParam.getPassword())) {
                    return Result.success(ResultType.LOGIN_SUCCESS, user.getId());
                } else {
                    return Result.fail(ResultType.LOGIN_FAIL_INVALID_PASSWORD);
                }
            } else {
                return Result.fail(ResultType.LOGIN_FAIL_USER_NOT_EXIST);
            }
        }catch (Exception e) {
            return Result.fail(ResultType.LOGIN_FAILURE);
        }
    }

    @Override
    public Result register(UserForm userForm) {
        User userHis = userMapper.select(userForm.getUsername());
        if (userHis != null) {
            return Result.fail(ResultType.REGISTER_FAIL_USERNAME_EXIST);
        }
        User user = userForm.toPo(User.class);
        long userId = userMapper.insert(user);
        if(userId == 0) {
            return Result.fail(ResultType.REGISTER_FAILURE);
        }
        //初始化账户
        Account account = new Account(user.getId(), "0");
        long accountId = accountMapper.insert(account);
        if(accountId == 0) {
            return Result.fail(ResultType.REGISTER_FAILURE);
        }
        return Result.success(ResultType.REGISTER_SUCCESS, userId);
    }

    @Override
    public Result chgPwd(UserChgForm userChgForm) {
        try {
            List<User> userList = userMapper.query(new UserQueryParam(userChgForm.getUsername(), userChgForm.getOldpwd()));
            if (userList != null && userList.size() == 1) {
                User user = userChgForm.toPo(User.class);
                user.setId(userList.get(0).getId());
                userMapper.update(user);
                return Result.success(ResultType.CHGPWD_SUCCESS);
            } else if (userList != null && userList.size() > 1) {
                return Result.fail(ResultType.CHGPWD_FAILURE);
            } else {
                return Result.fail(ResultType.CHGPWD_FAIL_WRONG_OLDPWD);
            }
        }catch (Exception e) {
            return Result.fail(ResultType.CHGPWD_FAILURE);
        }
    }

    @Override
    public Result queryByPage(UserQueryPageForm userQueryPageForm) {
        Page page = PageHelper.startPage(userQueryPageForm.getPageNum(), userQueryPageForm.getPageSize());
        List<UserVo> userVos = userMapper.queryByPage(userQueryPageForm.toParam(UserQueryPageParam.class));
        PageInfo<UserVo> pageInfo = new PageInfo<>(userVos);
        pageInfo.setTotal(page.getTotal());
        return Result.success(pageInfo);
    }
}

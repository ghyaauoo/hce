package com.hce.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hce.base.entity.vo.Result;
import com.hce.dao.ChargeLogMapper;
import com.hce.dao.UserMapper;
import com.hce.entity.form.ChargeLogQueryForm;
import com.hce.entity.param.ChargeLogQueryParam;
import com.hce.entity.param.UserQueryParam;
import com.hce.entity.po.ChargeLog;
import com.hce.entity.po.User;
import com.hce.entity.vo.ChargeLogVo;
import com.hce.exception.ResultType;
import com.hce.service.IChargeLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: 高浩宇
 * @Desc:
 * @Date: Created in 2019/5/9 03:46
 * @modified by:
 */
@Service
@Slf4j
public class ChargeLogService implements IChargeLogService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ChargeLogMapper chargeLogMapper;

    @Override
    public Result query(ChargeLogQueryForm chargeLogQueryForm) {
        List<User> users = userMapper.query(new UserQueryParam(chargeLogQueryForm.getUsername()));
        if (users != null && users.size() == 1) {
            List<ChargeLog> chargeLogList = chargeLogMapper.query(new ChargeLogQueryParam(users.get(0).getId()));
            List<ChargeLogVo> chargeLogVos = chargeLogList.stream().map(ChargeLogVo::new).collect(Collectors.toList());
            return Result.success(ResultType.QUERY_SUCCESS, JSONObject.toJSONString(chargeLogVos));
        }else {
            return Result.fail(ResultType.QUERY_FAILURE);
        }
    }
}

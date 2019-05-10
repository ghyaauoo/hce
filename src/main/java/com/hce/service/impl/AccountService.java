package com.hce.service.impl;

import com.hce.base.entity.vo.Result;
import com.hce.dao.AccountMapper;
import com.hce.dao.ChargeLogMapper;
import com.hce.dao.UserMapper;
import com.hce.entity.form.AccountChargeForm;
import com.hce.entity.form.AccountQueryForm;
import com.hce.entity.param.UserQueryParam;
import com.hce.entity.po.Account;
import com.hce.entity.po.ChargeLog;
import com.hce.entity.po.User;
import com.hce.exception.ResultType;
import com.hce.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

/**
 * @Auther: 高浩宇
 * @Desc:
 * @Date: Created in 2019/5/9 03:46
 * @modified by:
 */
@Service
@Slf4j
public class AccountService implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ChargeLogMapper chargeLogMapper;


    @Override
    public Result charge(AccountChargeForm accountChargeForm) {
        List<User> users = userMapper.query(new UserQueryParam(accountChargeForm.getUsername()));
        if (users != null && users.size() == 1) {
            Account account = accountMapper.select(users.get(0).getId());
            BigDecimal balance = new BigDecimal(account.getBalance());
            BigDecimal charge = new BigDecimal(accountChargeForm.getCharge());
            account.setBalance(balance.add(charge, MathContext.DECIMAL64).toString());
            accountMapper.update(account);
            ChargeLog chargeLog = new ChargeLog(users.get(0).getId(), charge.toString());
            long chargeId = chargeLogMapper.insert(chargeLog);
            if (chargeId == 0) {
                return Result.fail(ResultType.CHARGE_FAILURE);
            }
            return Result.success(ResultType.CHARGE_SUCCESS);
        } else {
            return Result.fail(ResultType.CHARGE_FAILURE);
        }
    }

    @Override
    public Result query(AccountQueryForm accountQueryForm) {
        List<User> users = userMapper.query(new UserQueryParam(accountQueryForm.getUsername()));
        if (users != null && users.size() == 1) {
            Account account = accountMapper.select(users.get(0).getId());
            if (account != null) {
                return Result.success(ResultType.QUERY_SUCCESS, account.getBalance());
            }
            return Result.fail(ResultType.QUERY_FAILURE, "0");
        }else {
            return Result.fail(ResultType.QUERY_FAILURE, "0");
        }
    }
}

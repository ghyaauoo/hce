package com.hce.service;

import com.hce.base.entity.vo.Result;
import com.hce.entity.form.ChargeLogQueryForm;

/**
 * @Auther: 高浩宇
 * @Desc:
 * @Date: Created in 2019/5/9 03:45
 * @modified by:
 */
public interface IChargeLogService {

    Result query(ChargeLogQueryForm chargeLogQueryForm);

}

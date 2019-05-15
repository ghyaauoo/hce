package com.hce.entity.vo;

import com.hce.base.entity.vo.BaseVo;
import com.hce.entity.po.ChargeLog;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;

/**
 * @Auther: 高浩宇
 * @Desc:
 * @Date: Created in 2019/5/9 14:54
 * @modified by:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
@NoArgsConstructor
public class ChargeLogPageVo extends BaseVo {

    private String charge;

    private String time;

}

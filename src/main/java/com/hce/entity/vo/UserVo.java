package com.hce.entity.vo;

import com.hce.base.entity.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Auther: 高浩宇
 * @Desc:
 * @Date: Created in 2019/5/12 07:54
 * @modified by:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
@NoArgsConstructor
public class UserVo  extends BaseVo {

    private Long id;

    private String username;

    private String createdBy;

    private String createdTime;

    private String balance;

    private List<ChargeLogPageVo> chargeLogVoList;
}

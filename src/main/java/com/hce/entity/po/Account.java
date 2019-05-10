package com.hce.entity.po;

import com.hce.base.entity.po.BasePo;
import lombok.*;

/**
 * @Auther: 高浩宇
 * @Desc: 账户信息
 * @Date: Created in 2019/5/9 02:58
 * @modified by:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BasePo {

    private Long userId;

    private String balance;

}

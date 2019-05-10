package com.hce.entity.po;

import com.hce.base.entity.po.BasePo;
import lombok.*;

/**
 * @Auther: 高浩宇
 * @Desc:
 * @Date: Created in 2019/5/9 02:58
 * @modified by:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BasePo {

    private String username;

    private String password;
}

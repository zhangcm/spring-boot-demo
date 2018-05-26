package com.study.domain.user;

import com.study.base.BaseBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @since 1.0, 2017/9/20 下午6:09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseBean {

    private int id;

    private String name;

    private int age;

}

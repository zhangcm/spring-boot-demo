package com.study.domain.user;

import com.study.base.BaseBean;
import lombok.Builder;
import lombok.Data;

/**
 * @since 1.0, 2017/9/20 下午6:09
 */
@Data
@Builder
public class User extends BaseBean {

    private long id;

    private String name;

    private int age;

}

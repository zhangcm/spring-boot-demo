package com.study.domain.user;

import org.springframework.stereotype.Component;

/**
 * @since 1.0, 2017/9/20 下午6:14
 */
@Component
public class UserRepository {

    User findOne(int id) {
        return User.builder().id(id).name("name").age(20).build();
    }
}

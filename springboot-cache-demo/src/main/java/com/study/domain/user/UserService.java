package com.study.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @since 1.0, 2017/9/20 下午6:14
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userTokenRepository;

    @Cacheable("user")
    public User get(long id) {
        return userTokenRepository.findOne(id);
    }
}

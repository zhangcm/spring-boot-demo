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

    /**
     * 配置了StringRedisSerializer后，要求key必须是String类型，此处int强转String会报错，
     * 提供一个keyGenerator做转化
     */
    @Cacheable(value = "user", keyGenerator = "keyGenerator")
    public User get(int id) {
        return userTokenRepository.findOne(id);
    }
}

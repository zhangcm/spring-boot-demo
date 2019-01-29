package com.study.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

/**
 * @author zhangcm
 * @since 1.0, 2019/1/29 11:39 AM
 */
@Component
@ManagedResource
public class RedisUtil {

    private static RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate<Object, Object> redisTemplate) {
        RedisUtil.redisTemplate = redisTemplate;
    }

    @ManagedOperation
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @ManagedOperation
    public String getString(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }
}

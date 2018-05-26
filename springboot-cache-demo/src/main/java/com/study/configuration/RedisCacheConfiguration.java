package com.study.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;

/**
 * @author zhangcm
 * @since 1.0, 2017/9/21 上午10:08
 */
@Configuration
@ConditionalOnProperty(prefix = "spring.redis", name = "host")
public class RedisCacheConfiguration {

    @Bean
    public RedisCacheManager cacheManager(RedisTemplate<Object, Object> redisTemplate) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        GenericJackson2JsonRedisSerializer jsonValueSerializer = new GenericJackson2JsonRedisSerializer();
        redisTemplate.setValueSerializer(jsonValueSerializer);

        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        cacheManager.setUsePrefix(true);
        cacheManager.setCachePrefix(cacheName -> "user-".getBytes());
        return cacheManager;
    }

    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {

            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                sb.append(o.getClass().getName());
                sb.append(":" + method.getName());
                for (Object obj : objects) {
                    sb.append(":" + obj.toString());
                }
                return sb.toString();
            }
        };
    }

}

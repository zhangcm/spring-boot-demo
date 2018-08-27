package com.study.support;

import com.justz.lock.interceptor.KeyGenerator;

import java.lang.reflect.Method;

/**
 * @author OF1264
 * @since 1.0, 2018/6/6 上午11:04
 */
public class AnotherLockKeyGenerator implements KeyGenerator {
    @Override
    public String generate(Class<?> aClass, Method method, String s, Object... objects) {
        return "another_key";
    }
}

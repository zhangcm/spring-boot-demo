package com.study.support;

import com.justz.lock.interceptor.KeyGenerator;

import java.lang.reflect.Method;

/**
 * @author OF1264
 * @since 1.0, 2018/6/6 上午10:32
 */
public class LockKeyGenerator implements KeyGenerator {

    @Override
    public String generate(Class<?> aClass, Method method, String s, Object... objects) {
        return "my_lock";
    }
}

package com.study.annotation;

import com.justz.lock.annotation.Lock;
import com.justz.lock.annotation.LockConfig;

import java.lang.annotation.*;

/**
 * @author OF1264
 * @since 1.0, 2018/6/6 上午11:11
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Lock(keyGenerator = "anotherLockGenerator")
public @interface AnotherLock {
}

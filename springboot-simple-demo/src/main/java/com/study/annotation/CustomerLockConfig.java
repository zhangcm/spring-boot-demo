package com.study.annotation;

import com.justz.lock.annotation.LockConfig;

import java.lang.annotation.*;

/**
 * @author OF1264
 * @since 1.0, 2018/6/6 上午10:34
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@LockConfig(keyGenerator = "lockGenerator")
public @interface CustomerLockConfig {
}

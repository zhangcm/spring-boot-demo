package com.study.service;

import com.qianmi.lock.annotation.Lock;
import org.springframework.stereotype.Service;

/**
 * @author zhangcm
 * @since 1.0, 2018/5/26 下午4:14
 */
@Service
public class LockTestService {

    public void sayHi() {
        System.out.println("Hi");
    }

    @Lock
    public void sayHelloWithLock() {
        System.out.println("Hello");
    }

}

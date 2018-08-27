package com.study.service;

import com.justz.lock.annotation.Lock;
import com.justz.lock.annotation.LockParam;
import com.study.annotation.AnotherLock;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author zhangcm
 * @since 1.0, 2018/5/26 下午4:14
 */
@Service
public class LockTestService {

    public void sayHi(@LockParam String name) {
        System.out.println("Hi, " + name);
    }

    @Lock(prefix = "hello")
    public Object sayHelloWithLock(@LockParam String name) {
        System.out.println(name);
        return null;
    }

    @AnotherLock
    public Object anotherSayHello(@LockParam String name) {
        System.out.println(name);
        return null;
    }

    @Async
    public void asyncSayHello() {
        System.out.println("Async Hello");
    }

}

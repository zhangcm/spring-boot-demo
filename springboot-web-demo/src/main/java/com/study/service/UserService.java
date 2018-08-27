package com.study.service;

import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

/**
 * @author zhangcm
 * @since 1.0, 2018/6/9 下午5:01
 */
@Service
@ManagedResource
public class UserService {

    public void sayHello() {
        System.out.println("Hello");
    }
}



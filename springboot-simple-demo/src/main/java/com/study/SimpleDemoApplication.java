package com.study;

import com.qianmi.lock.annotation.EnableLock;
import com.study.service.LockTestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author zhangcm
 * @since 1.0, 2017/10/30 上午11:31
 */
@SpringBootApplication
@EnableLock
public class SimpleDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SimpleDemoApplication.class, args);
        LockTestService service = ctx.getBean(LockTestService.class);
        service.sayHi();
        service.sayHelloWithLock();
    }

}

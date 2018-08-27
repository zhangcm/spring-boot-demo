package com.study;

import com.justz.lock.annotation.EnableLock;
import com.justz.lock.interceptor.KeyGenerator;
import com.study.service.LockTestService;
import com.study.support.AnotherLockKeyGenerator;
import com.study.support.LockKeyGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zhangcm
 * @since 1.0, 2017/10/30 上午11:31
 */
@SpringBootApplication
@EnableLock
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SimpleDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SimpleDemoApplication.class, args);
        LockTestService service = ctx.getBean(LockTestService.class);
        service.sayHi("Jerry");
        service.sayHelloWithLock("Wolrd");
        service.asyncSayHello();
        service.sayHelloWithLock("Man");

        service.anotherSayHello("world");
    }

    @Bean(name = "lockGenerator")
    public KeyGenerator lockGenerator() {
        return new LockKeyGenerator();
    }

    @Bean(name = "anotherLockGenerator")
    public KeyGenerator anotherLockGenerator() {
        return new AnotherLockKeyGenerator();
    }

}

package com.study;

import com.study.service.ConfigService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @since 1.0, 2017/7/21 下午2:15
 */
@SpringBootApplication
public class ProfileDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(ProfileDemoApplication.class, args);
        ConfigService configService = ctx.getBean(ConfigService.class);
        System.out.println("/********************************************/");
        System.out.println(configService.getName());
        System.out.println(configService.getHost());
        System.out.println("/********************************************/");
    }
}

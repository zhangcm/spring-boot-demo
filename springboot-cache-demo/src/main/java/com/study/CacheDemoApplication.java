package com.study;

import com.study.domain.user.User;
import com.study.domain.user.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

/**
 * @author zhangcm
 * @since 1.0, 2017/9/20 下午6:15
 */
@EnableCaching
@SpringBootApplication
public class CacheDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(CacheDemoApplication.class, args);

        UserService userTokenService = ctx.getBean(UserService.class);
        User userToken = userTokenService.get(1);
        System.out.println(userToken.getName());
        userToken = userTokenService.get(1);
        System.out.println(userToken.getName());
    }
}

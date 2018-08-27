package com.study;

import com.study.sender.KafkaSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author zhangcm
 * @since 1.0, 2018/8/7 下午4:28
 */
@SpringBootApplication
public class KafkaDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(KafkaDemoApplication.class, args);

        KafkaSender kafkaSender = ctx.getBean(KafkaSender.class);
        kafkaSender.send();
    }
}

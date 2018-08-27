package com.study.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author zhangcm
 * @since 1.0, 2018/8/7 下午4:29
 */
@Component
public class KafkaConsumer {

    @KafkaListener(topics = {"LOGSTASH_APP_LOG"})
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.println(record);
    }
}

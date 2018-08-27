package com.study.sender;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.study.bean.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author zhangcm
 * @since 1.0, 2018/8/7 下午4:37
 */
@Component
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    public void send() {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        kafkaTemplate.send("LOGSTASH_APP_LOG", System.currentTimeMillis() + "'", gson.toJson(message));
    }
}

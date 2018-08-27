package com.study.activemq;

import com.study.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author zhangcm
 * @since 1.0, 2018/6/15 下午1:44
 */
@Service
public class MessageSender {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendTopicMessage(SendMqTopicEnum mqTopicEnum, List<Object> messages) {
        if (CollectionUtils.isEmpty(messages)) {
            return;
        }
        messages.forEach(message -> {
            String json = JsonUtil.toJSONString(message);
            jmsMessagingTemplate.convertAndSend(mqTopicEnum.getActiveMQTopic(), json);
            try {
                System.out.println("Send Message: " + json);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}

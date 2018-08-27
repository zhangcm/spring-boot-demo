package com.study.activemq;

import org.apache.activemq.command.ActiveMQTopic;

/**
 * @author zhangcm
 * @since 1.0, 2018/6/15 下午1:45
 */
public enum SendMqTopicEnum {

    USER_CHANGE("topic.user.changed") {

        final ActiveMQTopic TOPIC = new ActiveMQTopic(getTopicName());

        @Override
        public ActiveMQTopic getActiveMQTopic() {
            return TOPIC;
        }
    };

    private String topicName;

    SendMqTopicEnum(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicName() {
        return topicName;
    }

    public abstract ActiveMQTopic getActiveMQTopic();
}

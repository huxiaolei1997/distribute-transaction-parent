package com.xlh.distribute.transaction.rocketmq.msg.demo.config;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年12月27日 11:20 胡晓磊 Exp $
 */
@Configuration
public class RocketMQConfig {

    @Bean(destroyMethod = "shutdown", initMethod = "start")
    public DefaultMQProducer producer() {
        DefaultMQProducer producer = new DefaultMQProducer("paymentGroup");
        producer.setNamesrvAddr("localhost:9876");
        return producer;
    }

    @Bean(destroyMethod = "shutdown", initMethod = "start")
    public DefaultMQPushConsumer consumer(@Qualifier("messageListenerConcurrently") MessageListenerConcurrently messageListenerConcurrently) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("paymentConsumerGroup");

        consumer.setNamesrvAddr("localhost:9876");
        consumer.subscribe("payment", "*");


        consumer.registerMessageListener(messageListenerConcurrently);

        return consumer;
    }
}

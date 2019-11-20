package com.zzdz.rocketmq.service;

import com.zzdz.rocketmq.model.OrderPaidEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RocketMQMessageListener(topic = "TestMessage", consumerGroup = "my-consumer_test-topic-3")
public class MyConsumer3 implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("received orderPaidEvent: {}", message);
    }
}

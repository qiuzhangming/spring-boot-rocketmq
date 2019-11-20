package com.zzdz.rocketmq.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
//@Service
public class Sender {

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    @Async
    @Scheduled(cron = "0/1 * * * * ?")
    public void send1() {
        SendResult sendResult = rocketMQTemplate.syncSend("TestMessage", "hello");
        log.info(sendResult.toString());
    }
}

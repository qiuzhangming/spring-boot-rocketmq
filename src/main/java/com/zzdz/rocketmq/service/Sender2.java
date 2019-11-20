package com.zzdz.rocketmq.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Sender2 implements CommandLineRunner {

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    @Override
    public void run(String... args) throws Exception {
        while (true) {

//            SendResult sendResult = rocketMQTemplate.syncSend("TestMessage", "hello");
//            log.info(sendResult.toString());


//            rocketMQTemplate.asyncSend("TestMessage", "hello,async", new SendCallback() {
//                @Override
//                public void onSuccess(SendResult sendResult) {
//                    log.info(sendResult.toString());
//                }
//
//                @Override
//                public void onException(Throwable throwable) {
//                    log.error(throwable.toString());
//                }
//            });

//            rocketMQTemplate.sendOneWay("TestMessage", "hello,one way");

            rocketMQTemplate.convertAndSend("test-topic-1", "Hello, World!");

        }
    }
}

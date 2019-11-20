package com.zzdz.rocketmq;

import com.zzdz.rocketmq.model.OrderPaidEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRocketmqApplicationTests {

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    @Test
    public void contextLoads() {
    }

    @Test
    public void sendMeaasge() {
        while (true) {
            SendResult sendResult = rocketMQTemplate.syncSend("TestMessage", "hello");
            log.info(sendResult.toString());

            rocketMQTemplate.convertAndSend("test-topic-1", "Hello, World!");
            rocketMQTemplate.send("test-topic-1", MessageBuilder.withPayload("Hello, World! I'm from spring message").build());
            rocketMQTemplate.convertAndSend("test-topic-2", new OrderPaidEvent("T_001", new BigDecimal("88.00")));
            // // notes:  once rocketMQTemplate be destroyed, you can not send any message again with this rocketMQTemplate
            // rocketMQTemplate.destroy();

        }
    }

}

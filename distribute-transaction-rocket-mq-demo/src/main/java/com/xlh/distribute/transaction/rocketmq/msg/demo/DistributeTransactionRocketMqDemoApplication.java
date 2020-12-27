package com.xlh.distribute.transaction.rocketmq.msg.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DistributeTransactionRocketMqDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributeTransactionRocketMqDemoApplication.class, args);
    }

}

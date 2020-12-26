package com.xlh.distribute.transaction.local.msg.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DistributeTransactionLocalMsgDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributeTransactionLocalMsgDemoApplication.class, args);
    }

}

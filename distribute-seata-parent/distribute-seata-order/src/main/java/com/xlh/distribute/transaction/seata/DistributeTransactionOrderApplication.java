package com.xlh.distribute.transaction.seata;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan({"com.xlh.distribute.transaction.seata.order.mapper"})
@EnableDubbo
@DubboComponentScan(basePackages = {"com.xlh.distribute.transaction.seata.order.dubbo"})
public class DistributeTransactionOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributeTransactionOrderApplication.class, args);
    }

}

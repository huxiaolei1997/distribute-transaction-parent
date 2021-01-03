package com.xlh.distribute.transaction.seata;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDubbo
@MapperScan({"com.xlh.distribute.transaction.seata.storage.mapper"})
@DubboComponentScan(basePackages = {"com.xlh.distribute.transaction.seata.storage.dubbo"})
public class DistributeTransactionStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributeTransactionStorageApplication.class, args);
    }

}

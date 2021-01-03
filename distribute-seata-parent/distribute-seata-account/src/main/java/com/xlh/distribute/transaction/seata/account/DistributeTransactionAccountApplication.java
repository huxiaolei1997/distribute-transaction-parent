package com.xlh.distribute.transaction.seata.account;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.xlh.distribute.transaction.seata.account.mapper"})
@EnableDubbo
@DubboComponentScan(basePackages = {"com.xlh.distribute.transaction.seata.account.dubbo"})
public class DistributeTransactionAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributeTransactionAccountApplication.class, args);
    }

}

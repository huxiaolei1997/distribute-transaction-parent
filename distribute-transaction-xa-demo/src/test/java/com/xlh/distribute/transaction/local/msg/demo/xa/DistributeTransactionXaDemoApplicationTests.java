package com.xlh.distribute.transaction.local.msg.demo.xa;

import com.xlh.distribute.transaction.local.msg.demo.xa.service.XAService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DistributeTransactionXaDemoApplicationTests {

    @Autowired
    private XAService xaService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testXA() {
        xaService.testXA();
    }

//    @Tran
}

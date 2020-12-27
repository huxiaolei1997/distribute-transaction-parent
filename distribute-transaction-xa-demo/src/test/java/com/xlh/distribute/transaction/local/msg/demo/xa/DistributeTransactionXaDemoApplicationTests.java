package com.xlh.distribute.transaction.local.msg.demo.xa;

import com.xlh.distribute.transaction.demo.xa.DistributeTransactionXaDemoApplication;
import com.xlh.distribute.transaction.demo.xa.service.XAService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DistributeTransactionXaDemoApplication.class)
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

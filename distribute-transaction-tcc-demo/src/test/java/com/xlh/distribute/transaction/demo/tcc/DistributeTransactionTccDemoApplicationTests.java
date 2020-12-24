package com.xlh.distribute.transaction.demo.tcc;

import com.xlh.distribute.transaction.demo.tcc.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DistributeTransactionTccDemoApplicationTests {

    @Autowired
    private AccountService accountService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testTransfer() {
        accountService.transfer();
    }

//    @Tran
}

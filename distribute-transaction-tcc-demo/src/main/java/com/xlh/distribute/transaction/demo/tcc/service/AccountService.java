package com.xlh.distribute.transaction.demo.tcc.service;

import com.xlh.distribute.transaction.demo.tcc.db1.dao.AccountAMapper;
import com.xlh.distribute.transaction.demo.tcc.db1.model.AccountA;
import com.xlh.distribute.transaction.demo.tcc.db2.dao.AccountBMapper;
import com.xlh.distribute.transaction.demo.tcc.db2.model.AccountB;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年12月20日 11:57 胡晓磊 Exp $
 */
@Service
public class AccountService {

    @Resource
    private AccountAMapper accountAMapper;

    @Resource
    private AccountBMapper accountBMapper;

    @Transactional(transactionManager = "tm1", rollbackFor = Exception.class)
    public void transfer() {
        AccountA accountA = accountAMapper.selectByPrimaryKey(1L);
        accountA.setBalance(accountA.getBalance().subtract(new BigDecimal(200)));
        accountAMapper.updateByPrimaryKey(accountA);

        AccountB accountB = new AccountB();
        accountB.setBalance(accountB.getBalance().add(new BigDecimal(200)));
        accountBMapper.updateByPrimaryKey(accountB);
        try {
            int i = 10 / 0;
        } catch (Exception e) {
            // 这里最好捕获的是自定义异常，如果补偿出现了异常，那么可以重试补偿逻辑，超过次数则计入日志
            try {
                Long id = accountB.getId();
                accountB = new AccountB();
                accountB.setId(id);
                accountB.setBalance(accountB.getBalance().subtract(new BigDecimal(200)));
                accountBMapper.updateByPrimaryKey(accountB);
            } catch (Exception e1) {

            }


            // 需要把异常抛出，否则accountA不会回滚
            throw e;
        }

    }
}

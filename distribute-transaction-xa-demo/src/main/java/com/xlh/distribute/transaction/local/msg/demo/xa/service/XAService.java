package com.xlh.distribute.transaction.local.msg.demo.xa.service;

import com.xlh.distribute.transaction.local.msg.demo.xa.db1.dao.Xa1Mapper;
import com.xlh.distribute.transaction.local.msg.demo.xa.db1.model.Xa1;
import com.xlh.distribute.transaction.local.msg.demo.xa.db2.dao.Xa2Mapper;
import com.xlh.distribute.transaction.local.msg.demo.xa.db2.model.Xa2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年12月20日 11:57 胡晓磊 Exp $
 */
@Service
public class XAService {

    @Resource
    private Xa1Mapper xa1Mapper;

    @Resource
    private Xa2Mapper xa2Mapper;

    @Transactional(transactionManager = "jtaTransactionManager")
    public void testXA() {
        Xa1 xa1 = new Xa1();
        xa1.setId(2L);
        xa1.setName("xa_1");

        xa1Mapper.insert(xa1);

        Xa2 xa2 = new Xa2();
        xa2.setId(2L);
        xa2.setName("xa_2");

        xa2Mapper.insert(xa2);

        throw new RuntimeException("aaaaa");
    }
}

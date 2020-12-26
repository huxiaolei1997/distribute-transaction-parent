package com.xlh.distribute.transaction.local.msg.demo.service;

import com.xlh.distribute.transaction.local.msg.demo.db1.dao.AccountAMapper;
import com.xlh.distribute.transaction.local.msg.demo.db1.dao.PaymentMsgMapper;
import com.xlh.distribute.transaction.local.msg.demo.db1.model.AccountA;
import com.xlh.distribute.transaction.local.msg.demo.db1.model.PaymentMsg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年12月26日 20:33 胡晓磊 Exp $
 */
@Service
public class PaymentService {
    @Resource
    private AccountAMapper accountAMapper;

    @Resource
    private PaymentService paymentService;

    @Resource
    private PaymentMsgMapper paymentMsgMapper;
    /**
     * 支付接口
     *
     * @param userId
     * @param orderId
     * @param amount
     * @return 0:成功，1：用户不存在，2：余额不足
     */
    @Transactional(rollbackFor = Exception.class, transactionManager = "tm1")
    public int payment(long userId, int orderId, BigDecimal amount) {
        AccountA accountA = accountAMapper.selectByPrimaryKey(userId);

        if (accountA == null) {
            return 1;
        }

        if (accountA.getBalance().compareTo(amount) < 0) {
            return 2;
        }

        accountA.setBalance(accountA.getBalance().subtract(amount));
        accountAMapper.updateByPrimaryKey(accountA);

        PaymentMsg paymentMsg = new PaymentMsg();
        paymentMsg.setOrderId((long) orderId);
        paymentMsg.setFailureCnt(0);
        paymentMsg.setStatus(0);
        paymentMsg.setCreateUser((int) userId);
        paymentMsg.setUpdateUser((int) userId);
        paymentMsg.setCreateTime(new Date());
        paymentMsg.setUpdateTime(new Date());

        paymentMsgMapper.insertSelective(paymentMsg);
        return 0;
    }
}

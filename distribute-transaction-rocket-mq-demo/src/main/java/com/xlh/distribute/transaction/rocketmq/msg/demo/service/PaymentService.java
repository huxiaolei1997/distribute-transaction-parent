package com.xlh.distribute.transaction.rocketmq.msg.demo.service;

import com.xlh.distribute.transaction.rocketmq.msg.demo.db1.dao.AccountAMapper;
import com.xlh.distribute.transaction.rocketmq.msg.demo.db1.dao.PaymentMsgMapper;
import com.xlh.distribute.transaction.rocketmq.msg.demo.db1.model.AccountA;
import com.xlh.distribute.transaction.rocketmq.msg.demo.db1.model.PaymentMsg;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
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


    @Resource
    private DefaultMQProducer producer;

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

    @Transactional(rollbackFor = Exception.class, transactionManager = "tm1")
    public int paymentMQ(long userId, int orderId, BigDecimal amount) throws Exception {
        AccountA accountA = accountAMapper.selectByPrimaryKey(userId);

        if (accountA == null) {
            return 1;
        }

        if (accountA.getBalance().compareTo(amount) < 0) {
            return 2;
        }

        accountA.setBalance(accountA.getBalance().subtract(amount));
        accountAMapper.updateByPrimaryKey(accountA);


        Message message = new Message();
        message.setTopic("payment");
        message.setKeys("" + orderId);
        message.setBody("订单已支付".getBytes());
        try {
            SendResult sendResult = producer.send(message);
            if (sendResult.getSendStatus().equals(SendStatus.SEND_OK)) {
                return 0;
            } else {
                throw new Exception("消息发送失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}

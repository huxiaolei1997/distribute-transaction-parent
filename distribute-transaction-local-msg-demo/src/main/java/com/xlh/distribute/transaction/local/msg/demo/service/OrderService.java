package com.xlh.distribute.transaction.local.msg.demo.service;

import com.xlh.distribute.transaction.local.msg.demo.db1.dao.AccountAMapper;
import com.xlh.distribute.transaction.local.msg.demo.db1.dao.PaymentMsgMapper;
import com.xlh.distribute.transaction.local.msg.demo.db1.model.AccountA;
import com.xlh.distribute.transaction.local.msg.demo.db1.model.PaymentMsg;
import com.xlh.distribute.transaction.local.msg.demo.db2.dao.OrderMapper;
import com.xlh.distribute.transaction.local.msg.demo.db2.model.Order;
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
public class OrderService {
    @Resource
    private OrderMapper orderMapper;

    /**
     * 订单回调接口
     *
     * @return
     */
    public int handleOrder(int orderId) {
        Order order = orderMapper.selectByPrimaryKey((long) orderId);

        throw new RuntimeException("系统异常");

//        if (order == null) {
//            return 1;
//        }
//
//        // 已支付
//        order.setOrderStatus(1);
//        order.setUpdateTime(new Date());
////        order.setUpdateUser(String.valueOf(0));
//        orderMapper.updateByPrimaryKey(order);
//        return 0;
    }
}

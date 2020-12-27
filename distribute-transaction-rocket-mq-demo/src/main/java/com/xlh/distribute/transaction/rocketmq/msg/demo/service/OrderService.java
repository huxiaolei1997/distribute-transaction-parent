package com.xlh.distribute.transaction.rocketmq.msg.demo.service;

import com.xlh.distribute.transaction.rocketmq.msg.demo.db2.dao.OrderMapper;
import com.xlh.distribute.transaction.rocketmq.msg.demo.db2.model.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

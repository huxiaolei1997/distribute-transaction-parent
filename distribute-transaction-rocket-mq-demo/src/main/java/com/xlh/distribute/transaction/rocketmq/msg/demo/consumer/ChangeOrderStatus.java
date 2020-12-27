package com.xlh.distribute.transaction.rocketmq.msg.demo.consumer;

import com.xlh.distribute.transaction.rocketmq.msg.demo.db2.dao.OrderMapper;
import com.xlh.distribute.transaction.rocketmq.msg.demo.db2.model.Order;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年12月27日 11:36 胡晓磊 Exp $
 */
@Component(value = "messageListenerConcurrently")
public class ChangeOrderStatus implements MessageListenerConcurrently {
    @Resource
    private OrderMapper orderMapper;

    /**
     * msgs msgs.size() >= 1<br> DefaultMQPushConsumer.consumeMessageBatchMaxSize=1,you can modify here
     *
     * @param msgs
     * @param context
     * @return
     */
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        if (null == msgs || msgs.size() == 0) {
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }

        for (MessageExt msg : msgs) {
            String orderId = msg.getKeys();
            String body = new String(msg.getBody());

            Order order = orderMapper.selectByPrimaryKey(Long.valueOf(orderId));
            if (order == null) {
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }

            try {
                // 已支付
                order.setOrderStatus(1);
                order.setUpdateTime(new Date());
                orderMapper.updateByPrimaryKey(order);
            } catch (Exception e) {
                e.printStackTrace();
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }

        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}

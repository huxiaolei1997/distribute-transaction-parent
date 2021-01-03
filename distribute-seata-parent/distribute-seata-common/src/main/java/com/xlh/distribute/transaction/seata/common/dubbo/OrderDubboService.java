package com.xlh.distribute.transaction.seata.common.dubbo;

import com.xlh.distribute.transaction.seata.common.dto.OrderDTO;
import com.xlh.distribute.transaction.seata.common.response.ObjectResponse;

/**
 * @Author: lidong
 * @Description 订单服务接口
 * @Date Created in 2019/9/5 16:28
 */
public interface OrderDubboService {

    /**
     * 创建订单
     */
    ObjectResponse<OrderDTO> createOrder(OrderDTO orderDTO);
}

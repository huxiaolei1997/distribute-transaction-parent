package com.xlh.distribute.transaction.seata.order.service;

import com.xlh.distribute.transaction.seata.common.dto.OrderDTO;
import com.xlh.distribute.transaction.seata.common.response.ObjectResponse;

/**
 * <p>
 * 创建订单
 * </p>
 * <p>
 * * @author lidong
 *
 * @since 2019-09-04
 */
public interface ITOrderService {

    /**
     * 创建订单
     */
    ObjectResponse<OrderDTO> createOrder(OrderDTO orderDTO);
}

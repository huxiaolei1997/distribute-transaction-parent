package com.xlh.distribute.transaction.seata.order.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.xlh.distribute.transaction.seata.common.dto.OrderDTO;
import com.xlh.distribute.transaction.seata.common.dubbo.OrderDubboService;
import com.xlh.distribute.transaction.seata.common.response.ObjectResponse;
import com.xlh.distribute.transaction.seata.order.service.ITOrderService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: heshouyou
 * @Description
 * @Date Created in 2019-09-04
 */
@Service(version = "${dubbo.application.version}", protocol = "${dubbo.protocol.id}",
        application = "${dubbo.application.id}", registry = "${dubbo.registry.id}",
        timeout = 3000)
@Slf4j
public class OrderDubboServiceImpl implements OrderDubboService {

    @Autowired
    private ITOrderService orderService;

    @Override
    public ObjectResponse<OrderDTO> createOrder(OrderDTO orderDTO) {
        log.info("全局事务id ：" + RootContext.getXID());
        return orderService.createOrder(orderDTO);
    }
}

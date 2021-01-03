package com.xlh.distribute.transaction.seata.order.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xlh.distribute.transaction.seata.common.dto.AccountDTO;
import com.xlh.distribute.transaction.seata.common.dto.OrderDTO;
import com.xlh.distribute.transaction.seata.common.dubbo.AccountDubboService;
import com.xlh.distribute.transaction.seata.common.enums.RspStatusEnum;
import com.xlh.distribute.transaction.seata.common.response.ObjectResponse;
import com.xlh.distribute.transaction.seata.order.entity.TOrder;
import com.xlh.distribute.transaction.seata.order.mapper.TOrderMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * <p>
 * 服务实现类
 * </p>
 * <p>
 * * @author lidong
 *
 * @since 2019-09-04
 */
@Service
public class TOrderServiceImpl implements ITOrderService {

    @Reference(version = "${dubbo.application.version}")
    private AccountDubboService accountDubboService;

    @Resource
    private TOrderMapper tOrderMapper;

    /**
     * 创建订单
     *
     * @Param: OrderDTO  订单对象
     * @Return: OrderDTO  订单对象
     */
    @Override
    public ObjectResponse<OrderDTO> createOrder(OrderDTO orderDTO) {
        ObjectResponse<OrderDTO> response = new ObjectResponse<>();
        //扣减用户账户
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserId(orderDTO.getUserId());
        accountDTO.setAmount(orderDTO.getOrderAmount());
        ObjectResponse objectResponse = accountDubboService.decreaseAccount(accountDTO);

        //生成订单号
        orderDTO.setOrderNo(UUID.randomUUID().toString().replace("-", ""));
        //生成订单
        TOrder tOrder = new TOrder();
        BeanUtils.copyProperties(orderDTO, tOrder);
        tOrder.setCount(orderDTO.getOrderCount());
        tOrder.setAmount(orderDTO.getOrderAmount().doubleValue());
        try {
            tOrderMapper.createOrder(tOrder);
        } catch (Exception e) {
            response.setStatus(RspStatusEnum.FAIL.getCode());
            response.setMessage(RspStatusEnum.FAIL.getMessage());
            return response;
        }

        if (objectResponse.getStatus() != 200) {
            response.setStatus(RspStatusEnum.FAIL.getCode());
            response.setMessage(RspStatusEnum.FAIL.getMessage());
            return response;
        }

        response.setStatus(RspStatusEnum.SUCCESS.getCode());
        response.setMessage(RspStatusEnum.SUCCESS.getMessage());
        return response;
    }
}

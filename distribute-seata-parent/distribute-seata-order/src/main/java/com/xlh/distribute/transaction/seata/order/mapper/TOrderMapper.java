package com.xlh.distribute.transaction.seata.order.mapper;

import com.xlh.distribute.transaction.seata.order.entity.TOrder;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 * <p>
 * * @author lidong
 *
 * @since 2019-09-04
 */
public interface TOrderMapper {

    /**
     * 创建订单
     *
     * @Param: order 订单信息
     * @Return:
     */
    void createOrder(@Param("order") TOrder order);
}

package com.xlh.distribute.transaction.seata.common.dubbo;

import com.xlh.distribute.transaction.seata.common.dto.CommodityDTO;
import com.xlh.distribute.transaction.seata.common.response.ObjectResponse;

/**
 * @Author: lidong
 * @Description 库存服务
 * @Date Created in 2019/9/5 16:22
 */
public interface StorageDubboService {

    /**
     * 扣减库存
     */
    ObjectResponse decreaseStorage(CommodityDTO commodityDTO);
}

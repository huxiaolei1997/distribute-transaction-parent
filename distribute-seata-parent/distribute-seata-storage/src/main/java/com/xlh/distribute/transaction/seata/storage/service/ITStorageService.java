package com.xlh.distribute.transaction.seata.storage.service;

import com.xlh.distribute.transaction.seata.common.dto.CommodityDTO;
import com.xlh.distribute.transaction.seata.common.response.ObjectResponse;

/**
 * 仓库服务
 * <p>
 * * @author lidong
 *
 * @since 2019-09-04
 */
public interface ITStorageService {

    /**
     * 扣减库存
     */
    ObjectResponse decreaseStorage(CommodityDTO commodityDTO);
}

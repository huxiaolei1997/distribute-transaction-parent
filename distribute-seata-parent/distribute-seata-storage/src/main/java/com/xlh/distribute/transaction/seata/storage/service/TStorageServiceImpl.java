package com.xlh.distribute.transaction.seata.storage.service;

import com.xlh.distribute.transaction.seata.common.dto.CommodityDTO;
import com.xlh.distribute.transaction.seata.common.enums.RspStatusEnum;
import com.xlh.distribute.transaction.seata.common.response.ObjectResponse;
import com.xlh.distribute.transaction.seata.storage.mapper.TStorageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 库存服务实现类
 * </p>
 * <p>
 * * @author lidong
 *
 * @since 2019-09-04
 */
@Service
public class TStorageServiceImpl implements ITStorageService {

    @Resource
    private TStorageMapper tStorageMapper;

    @Override
    public ObjectResponse decreaseStorage(CommodityDTO commodityDTO) {
        int storage = tStorageMapper.decreaseStorage(commodityDTO.getCommodityCode(), commodityDTO.getCount());
        ObjectResponse<Object> response = new ObjectResponse<>();
        if (storage > 0) {
            response.setStatus(RspStatusEnum.SUCCESS.getCode());
            response.setMessage(RspStatusEnum.SUCCESS.getMessage());
            return response;
        }

        response.setStatus(RspStatusEnum.FAIL.getCode());
        response.setMessage(RspStatusEnum.FAIL.getMessage());
        return response;
    }
}

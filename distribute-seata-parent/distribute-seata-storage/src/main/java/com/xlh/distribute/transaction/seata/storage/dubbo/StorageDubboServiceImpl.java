package com.xlh.distribute.transaction.seata.storage.dubbo;


import com.alibaba.dubbo.config.annotation.Service;
import com.xlh.distribute.transaction.seata.common.dto.CommodityDTO;
import com.xlh.distribute.transaction.seata.common.dubbo.StorageDubboService;
import com.xlh.distribute.transaction.seata.common.response.ObjectResponse;
import com.xlh.distribute.transaction.seata.storage.service.ITStorageService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: heshouyou
 * @Description
 * @Date Created in 2019/1/23 16:13
 */
@Service(version = "${dubbo.application.version}", protocol = "${dubbo.protocol.id}",
        application = "${dubbo.application.id}", registry = "${dubbo.registry.id}",
        timeout = 3000)
@Slf4j
public class StorageDubboServiceImpl implements StorageDubboService {

    @Autowired
    private ITStorageService storageService;

    @Override
    public ObjectResponse decreaseStorage(CommodityDTO commodityDTO) {
        log.info("全局事务id ：" + RootContext.getXID());
        return storageService.decreaseStorage(commodityDTO);
    }
}

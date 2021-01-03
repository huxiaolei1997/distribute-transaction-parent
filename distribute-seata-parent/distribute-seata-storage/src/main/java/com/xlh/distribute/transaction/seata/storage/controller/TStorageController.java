package com.xlh.distribute.transaction.seata.storage.controller;

import com.xlh.distribute.transaction.seata.common.dto.CommodityDTO;
import com.xlh.distribute.transaction.seata.common.response.ObjectResponse;
import com.xlh.distribute.transaction.seata.storage.service.ITStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 * <p>
 * * @author lidong
 *
 * @since 2019-09-04
 */
@RestController
@RequestMapping("/storage")
@Slf4j
public class TStorageController {


    @Autowired
    private ITStorageService storageService;

    /**
     * 扣减库存
     */
    @PostMapping("dec_storage")
    ObjectResponse decreaseStorage(@RequestBody CommodityDTO commodityDTO) {
        log.info("请求库存微服务：{}", commodityDTO.toString());
        return storageService.decreaseStorage(commodityDTO);
    }
}


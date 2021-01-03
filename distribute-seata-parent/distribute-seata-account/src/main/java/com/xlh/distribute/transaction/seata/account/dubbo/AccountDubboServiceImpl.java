package com.xlh.distribute.transaction.seata.account.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.xlh.distribute.transaction.seata.account.service.ITAccountService;
import com.xlh.distribute.transaction.seata.common.dto.AccountDTO;
import com.xlh.distribute.transaction.seata.common.dubbo.AccountDubboService;
import com.xlh.distribute.transaction.seata.common.response.ObjectResponse;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: heshouyou
 * @Description Dubbo Api Impl
 * @Date Created in 2019/1/23 14:40
 */
@Service(version = "${dubbo.application.version}", protocol = "${dubbo.protocol.id}",
        application = "${dubbo.application.id}", registry = "${dubbo.registry.id}",
        timeout = 3000)
@Slf4j
public class AccountDubboServiceImpl implements AccountDubboService {

    @Autowired
    private ITAccountService accountService;

    @Override
    public ObjectResponse decreaseAccount(AccountDTO accountDTO) {
        log.info("全局事务id ：" + RootContext.getXID());
        return accountService.decreaseAccount(accountDTO);
    }
}

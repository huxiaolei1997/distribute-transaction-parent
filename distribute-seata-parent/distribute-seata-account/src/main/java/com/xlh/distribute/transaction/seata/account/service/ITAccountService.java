package com.xlh.distribute.transaction.seata.account.service;

import com.xlh.distribute.transaction.seata.common.dto.AccountDTO;
import com.xlh.distribute.transaction.seata.common.response.ObjectResponse;

/**
 * <p>
 * 服务类
 * </p>
 * <p>
 * * @author lidong
 *
 * @since 2019-09-04
 */
public interface ITAccountService {

    /**
     * 扣用户钱
     */
    ObjectResponse decreaseAccount(AccountDTO accountDTO);
}

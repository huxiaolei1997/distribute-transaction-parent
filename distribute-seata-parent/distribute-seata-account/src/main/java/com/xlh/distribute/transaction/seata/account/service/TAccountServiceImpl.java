package com.xlh.distribute.transaction.seata.account.service;

import com.xlh.distribute.transaction.seata.account.mapper.TAccountMapper;
import com.xlh.distribute.transaction.seata.common.dto.AccountDTO;
import com.xlh.distribute.transaction.seata.common.enums.RspStatusEnum;
import com.xlh.distribute.transaction.seata.common.response.ObjectResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
public class TAccountServiceImpl implements ITAccountService {
    @Resource
    private TAccountMapper tAccountMapper;

    @Override
    public ObjectResponse decreaseAccount(AccountDTO accountDTO) {
        int account = tAccountMapper.decreaseAccount(accountDTO.getUserId(), accountDTO.getAmount().doubleValue());
        ObjectResponse<Object> response = new ObjectResponse<>();
        if (account > 0) {
            response.setStatus(RspStatusEnum.SUCCESS.getCode());
            response.setMessage(RspStatusEnum.SUCCESS.getMessage());
            return response;
        }

        response.setStatus(RspStatusEnum.FAIL.getCode());
        response.setMessage(RspStatusEnum.FAIL.getMessage());
        return response;
    }
}

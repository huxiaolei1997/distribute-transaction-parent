package com.xlh.distribute.transaction.seata.account.mapper;

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
public interface TAccountMapper {

    /**
     * 减少账户余额
     *
     * @param userId
     * @param amount
     * @return
     */
    int decreaseAccount(@Param("userId") String userId, @Param("amount") Double amount);
}

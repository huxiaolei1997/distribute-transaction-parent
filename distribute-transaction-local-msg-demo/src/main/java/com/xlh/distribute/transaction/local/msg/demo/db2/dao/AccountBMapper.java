package com.xlh.distribute.transaction.local.msg.demo.db2.dao;

import com.xlh.distribute.transaction.local.msg.demo.db2.model.AccountB;
import com.xlh.distribute.transaction.local.msg.demo.db2.model.AccountBExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountBMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_b
     *
     * @mbg.generated Sun Dec 20 17:26:44 CST 2020
     */
    long countByExample(AccountBExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_b
     *
     * @mbg.generated Sun Dec 20 17:26:44 CST 2020
     */
    int deleteByExample(AccountBExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_b
     *
     * @mbg.generated Sun Dec 20 17:26:44 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_b
     *
     * @mbg.generated Sun Dec 20 17:26:44 CST 2020
     */
    int insert(AccountB record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_b
     *
     * @mbg.generated Sun Dec 20 17:26:44 CST 2020
     */
    int insertSelective(AccountB record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_b
     *
     * @mbg.generated Sun Dec 20 17:26:44 CST 2020
     */
    List<AccountB> selectByExample(AccountBExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_b
     *
     * @mbg.generated Sun Dec 20 17:26:44 CST 2020
     */
    AccountB selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_b
     *
     * @mbg.generated Sun Dec 20 17:26:44 CST 2020
     */
    int updateByExampleSelective(@Param("record") AccountB record, @Param("example") AccountBExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_b
     *
     * @mbg.generated Sun Dec 20 17:26:44 CST 2020
     */
    int updateByExample(@Param("record") AccountB record, @Param("example") AccountBExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_b
     *
     * @mbg.generated Sun Dec 20 17:26:44 CST 2020
     */
    int updateByPrimaryKeySelective(AccountB record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_b
     *
     * @mbg.generated Sun Dec 20 17:26:44 CST 2020
     */
    int updateByPrimaryKey(AccountB record);
}

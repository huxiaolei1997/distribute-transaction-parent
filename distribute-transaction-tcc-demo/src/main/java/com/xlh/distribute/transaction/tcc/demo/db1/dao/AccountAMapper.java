package com.xlh.distribute.transaction.tcc.demo.db1.dao;

import com.xlh.distribute.transaction.tcc.demo.db1.model.AccountA;
import com.xlh.distribute.transaction.tcc.demo.db1.model.AccountAExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AccountAMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_a
     *
     * @mbg.generated Sun Dec 20 17:29:18 CST 2020
     */
    long countByExample(AccountAExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_a
     *
     * @mbg.generated Sun Dec 20 17:29:18 CST 2020
     */
    int deleteByExample(AccountAExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_a
     *
     * @mbg.generated Sun Dec 20 17:29:18 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_a
     *
     * @mbg.generated Sun Dec 20 17:29:18 CST 2020
     */
    int insert(AccountA record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_a
     *
     * @mbg.generated Sun Dec 20 17:29:18 CST 2020
     */
    int insertSelective(AccountA record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_a
     *
     * @mbg.generated Sun Dec 20 17:29:18 CST 2020
     */
    List<AccountA> selectByExample(AccountAExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_a
     *
     * @mbg.generated Sun Dec 20 17:29:18 CST 2020
     */
    AccountA selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_a
     *
     * @mbg.generated Sun Dec 20 17:29:18 CST 2020
     */
    int updateByExampleSelective(@Param("record") AccountA record, @Param("example") AccountAExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_a
     *
     * @mbg.generated Sun Dec 20 17:29:18 CST 2020
     */
    int updateByExample(@Param("record") AccountA record, @Param("example") AccountAExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_a
     *
     * @mbg.generated Sun Dec 20 17:29:18 CST 2020
     */
    int updateByPrimaryKeySelective(AccountA record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_a
     *
     * @mbg.generated Sun Dec 20 17:29:18 CST 2020
     */
    int updateByPrimaryKey(AccountA record);
}

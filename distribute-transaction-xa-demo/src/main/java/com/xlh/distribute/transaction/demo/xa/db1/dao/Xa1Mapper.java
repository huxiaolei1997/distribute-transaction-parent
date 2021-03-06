package com.xlh.distribute.transaction.demo.xa.db1.dao;

import com.xlh.distribute.transaction.demo.xa.db1.model.Xa1;
import com.xlh.distribute.transaction.demo.xa.db1.model.Xa1Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Xa1Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_1
     *
     * @mbg.generated Sun Dec 20 11:28:32 CST 2020
     */
    long countByExample(Xa1Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_1
     *
     * @mbg.generated Sun Dec 20 11:28:32 CST 2020
     */
    int deleteByExample(Xa1Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_1
     *
     * @mbg.generated Sun Dec 20 11:28:32 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_1
     *
     * @mbg.generated Sun Dec 20 11:28:32 CST 2020
     */
    int insert(Xa1 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_1
     *
     * @mbg.generated Sun Dec 20 11:28:32 CST 2020
     */
    int insertSelective(Xa1 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_1
     *
     * @mbg.generated Sun Dec 20 11:28:32 CST 2020
     */
    List<Xa1> selectByExample(Xa1Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_1
     *
     * @mbg.generated Sun Dec 20 11:28:32 CST 2020
     */
    Xa1 selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_1
     *
     * @mbg.generated Sun Dec 20 11:28:32 CST 2020
     */
    int updateByExampleSelective(@Param("record") Xa1 record, @Param("example") Xa1Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_1
     *
     * @mbg.generated Sun Dec 20 11:28:32 CST 2020
     */
    int updateByExample(@Param("record") Xa1 record, @Param("example") Xa1Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_1
     *
     * @mbg.generated Sun Dec 20 11:28:32 CST 2020
     */
    int updateByPrimaryKeySelective(Xa1 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_1
     *
     * @mbg.generated Sun Dec 20 11:28:32 CST 2020
     */
    int updateByPrimaryKey(Xa1 record);
}

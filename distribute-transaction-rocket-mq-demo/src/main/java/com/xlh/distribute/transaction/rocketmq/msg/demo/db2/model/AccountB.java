package com.xlh.distribute.transaction.rocketmq.msg.demo.db2.model;

import java.math.BigDecimal;

public class AccountB {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_b.id
     *
     * @mbg.generated Sun Dec 20 17:26:44 CST 2020
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_b.name
     *
     * @mbg.generated Sun Dec 20 17:26:44 CST 2020
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_b.balance
     *
     * @mbg.generated Sun Dec 20 17:26:44 CST 2020
     */
    private BigDecimal balance;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_b.id
     *
     * @return the value of account_b.id
     * @mbg.generated Sun Dec 20 17:26:44 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_b.id
     *
     * @param id the value for account_b.id
     * @mbg.generated Sun Dec 20 17:26:44 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_b.name
     *
     * @return the value of account_b.name
     * @mbg.generated Sun Dec 20 17:26:44 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_b.name
     *
     * @param name the value for account_b.name
     * @mbg.generated Sun Dec 20 17:26:44 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_b.balance
     *
     * @return the value of account_b.balance
     * @mbg.generated Sun Dec 20 17:26:44 CST 2020
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_b.balance
     *
     * @param balance the value for account_b.balance
     * @mbg.generated Sun Dec 20 17:26:44 CST 2020
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
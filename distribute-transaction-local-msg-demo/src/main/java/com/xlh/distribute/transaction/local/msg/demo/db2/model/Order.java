package com.xlh.distribute.transaction.local.msg.demo.db2.model;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.id
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.order_status
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    private Integer orderStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.order_amount
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    private BigDecimal orderAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.receive_user
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    private String receiveUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.receive_mobile
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    private String receiveMobile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.create_user
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    private String createUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.create_time
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.update_user
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    private String updateUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.update_time
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.id
     *
     * @return the value of t_order.id
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.id
     *
     * @param id the value for t_order.id
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.order_status
     *
     * @return the value of t_order.order_status
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.order_status
     *
     * @param orderStatus the value for t_order.order_status
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.order_amount
     *
     * @return the value of t_order.order_amount
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.order_amount
     *
     * @param orderAmount the value for t_order.order_amount
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.receive_user
     *
     * @return the value of t_order.receive_user
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    public String getReceiveUser() {
        return receiveUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.receive_user
     *
     * @param receiveUser the value for t_order.receive_user
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    public void setReceiveUser(String receiveUser) {
        this.receiveUser = receiveUser == null ? null : receiveUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.receive_mobile
     *
     * @return the value of t_order.receive_mobile
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    public String getReceiveMobile() {
        return receiveMobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.receive_mobile
     *
     * @param receiveMobile the value for t_order.receive_mobile
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    public void setReceiveMobile(String receiveMobile) {
        this.receiveMobile = receiveMobile == null ? null : receiveMobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.create_user
     *
     * @return the value of t_order.create_user
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.create_user
     *
     * @param createUser the value for t_order.create_user
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.create_time
     *
     * @return the value of t_order.create_time
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.create_time
     *
     * @param createTime the value for t_order.create_time
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.update_user
     *
     * @return the value of t_order.update_user
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.update_user
     *
     * @param updateUser the value for t_order.update_user
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.update_time
     *
     * @return the value of t_order.update_time
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.update_time
     *
     * @param updateTime the value for t_order.update_time
     *
     * @mbg.generated Sat Dec 26 21:08:55 CST 2020
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

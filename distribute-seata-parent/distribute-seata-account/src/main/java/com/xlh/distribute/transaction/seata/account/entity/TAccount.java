package com.xlh.distribute.transaction.seata.account.entity;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 * <p>
 * * @author lidong
 *
 * @since 2019-09-04
 */
public class TAccount implements Serializable {


    private static final long serialVersionUID = -3249628376768078500L;
    private Integer id;
    private String userId;
    private Double amount;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "TAccount{" +
                ", id=" + id +
                ", userId=" + userId +
                ", amount=" + amount +
                "}";
    }
}

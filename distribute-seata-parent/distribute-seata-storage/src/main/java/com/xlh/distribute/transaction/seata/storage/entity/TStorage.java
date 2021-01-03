package com.xlh.distribute.transaction.seata.storage.entity;

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
public class TStorage implements Serializable {

    private static final long serialVersionUID = 7157518313856301812L;
    private Integer id;
    private String commodityCode;
    private String name;
    private Integer count;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


    @Override
    public String toString() {
        return "TStorage{" +
                ", id=" + id +
                ", commodityCode=" + commodityCode +
                ", name=" + name +
                ", count=" + count +
                "}";
    }
}

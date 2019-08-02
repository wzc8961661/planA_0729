package com.czxy.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * @author Lenovo
 * @version v 1.0
 * @date 2019/7/29
 */
@Table(name = "`order`")
public class Order {
    @Id
    private String oid;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date orderTime;
    private Integer orderStatus;
    private String address;
    private String name;
    private String telephone;
    private Integer uid;

    private List<OrderItem> orderItemList;

    public Order() {
    }

    public Order(String oid, Date orderTime, Integer orderStatus, String address, String name, String telephone, Integer uid, List<OrderItem> orderItemList) {
        this.oid = oid;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
        this.address = address;
        this.name = name;
        this.telephone = telephone;
        this.uid = uid;
        this.orderItemList = orderItemList;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", orderTime=" + orderTime +
                ", orderStatus=" + orderStatus +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", uid=" + uid +
                ", orderItemList=" + orderItemList +
                '}';
    }
}

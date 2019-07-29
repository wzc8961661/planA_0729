package com.czxy.domain;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lenovo
 * @version v 1.0
 * @date 2019/7/29
 */
@Table(name = "orderitem")
public class OrderItem {

    @Id
    private Integer itemId;
    private Integer quantity;
    private Double subPrice;
    private Integer pid;
    private Integer oid;

    private Product product;

    public OrderItem() {
    }

    public OrderItem(Integer itemId, Integer quantity, Double subPrice, Integer pid, Integer oid, Product product) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.subPrice = subPrice;
        this.pid = pid;
        this.oid = oid;
        this.product = product;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubPrice() {
        return subPrice;
    }

    public void setSubPrice(Double subPrice) {
        this.subPrice = subPrice;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemId=" + itemId +
                ", quantity=" + quantity +
                ", subPrice=" + subPrice +
                ", pid=" + pid +
                ", oid=" + oid +
                ", product=" + product +
                '}';
    }
}

package com.czxy.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 购物车项
 */
public class CartItem {
    private Product product;
    private int count;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date addTime;
    //    小计
    private Double subtotal;

    public CartItem() {
    }


    public CartItem(Product product, int count, Date addTime, Double subtotal) {
        this.product = product;
        this.count = count;
        this.addTime = addTime;
        this.subtotal = subtotal;
    }

    public Product getProduct() {

        return product;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Double getSubtotal() {
        subtotal = count * product.getShopPrice();
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", count=" + count +
                ", addTime=" + addTime +
                ", subtotal=" + subtotal +
                '}';
    }
}

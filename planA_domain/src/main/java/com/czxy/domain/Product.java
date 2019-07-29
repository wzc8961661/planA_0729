package com.czxy.domain;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lenovo
 * @version v 1.0
 * @date 2019/7/29
 */
@Table(name = "product")
public class Product {
    @Id
    private Integer pid;
    private String pname;
    private Double marketPrice;
    private Double shopPrice;
    private Double discount;
    private Integer sales;
    private String pimg;

    public Product() {
    }

    public Product(Integer pid, String pname, Double marketPrice, Double shopPrice, Double discount, Integer sales, String pimg) {
        this.pid = pid;
        this.pname = pname;
        this.marketPrice = marketPrice;
        this.shopPrice = shopPrice;
        this.discount = discount;
        this.sales = sales;
        this.pimg = pimg;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Double shopPrice) {
        this.shopPrice = shopPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", marketPrice=" + marketPrice +
                ", shopPrice=" + shopPrice +
                ", discount=" + discount +
                ", sales=" + sales +
                ", pimg='" + pimg + '\'' +
                '}';
    }
}

package com.czxy.domain;


/**
 * 购物车项
 */
public class CartItem {
    private Product product;
    private int count;
    //    小计
    private Double subtotal;

    public CartItem() {
    }


    public CartItem(Product product, int count, Double subtotal) {
        this.product = product;
        this.count = count;
        this.subtotal = subtotal;
    }

    public Product getProduct() {

        return product;
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
                ", subtotal=" + subtotal +
                '}';
    }
}

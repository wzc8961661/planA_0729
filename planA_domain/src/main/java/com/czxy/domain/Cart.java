package com.czxy.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cart {

    private Double total;
    private Map<Integer, CartItem> cartItemMap = new HashMap<>();

    //  添加购物车
    public void addCart(Product product, Integer count) {

        CartItem cartItem = cartItemMap.get(product.getPid());
        if (cartItem == null) {
            cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setCount(count);
            cartItemMap.put(product.getPid(), cartItem);
        } else {
            cartItem.setCount(cartItem.getCount() + count);
        }
    }

    /**
     * 移除购物车项
     *
     * @param pid
     */
    public void removerCartItem(Integer pid) {
        cartItemMap.remove(pid);
    }


    /**
     * 清空购物车
     */
    public void clean() {
        cartItemMap.clear();
        total = 0.0;
    }

    public Cart() {
    }

    public Cart(Double total, Map<Integer, CartItem> cartItemMap) {

        this.total = total;
        this.cartItemMap = cartItemMap;
    }

    public Double getTotal() {
        //每次调用 get方法都重新计算一次
        // 确保每次计算的数据都是最新的
        total = 0.0;
        Set<Map.Entry<Integer, CartItem>> entries = cartItemMap.entrySet();
        for (Map.Entry<Integer, CartItem> entry : entries) {
            total += entry.getValue().getSubtotal();
        }
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "total=" + total +
                ", cartItemMap=" + cartItemMap +
                '}';
    }
}

package com.czxy.service;

import com.czxy.domain.Order;

import java.util.List;

/**
 * @Author 黄开文
 * @Version v 1.0
 * @Date 2019/8/1
 */
public interface OrderService {

    public void saveOrder(Order order);

    public void updateAddress(Order order);

    public Order findOrderByOid(String oid);

    public List<Order> findOrderByUid(Integer uid);

    public void delOrder(String oid);
}

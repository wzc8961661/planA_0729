package com.czxy.service.impl;

import com.czxy.dao.OrderItemMapper;
import com.czxy.dao.OrderMapper;
import com.czxy.domain.Order;
import com.czxy.domain.OrderItem;
import com.czxy.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 黄开文
 * @Version v 1.0
 * @Date 2019/8/1
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderItemMapper orderItemMapper;

    @Override
    public void saveOrder(Order order) {
        orderMapper.insert(order);
        List<OrderItem> orderItemList = order.getOrderItemList();
        for (OrderItem orderItem : orderItemList) {
            orderItemMapper.insert(orderItem);
        }
    }

    @Override
    public void updateAddress(Order order) {
        orderMapper.saveAddress(order);
    }


    @Override
    public Order findOrderByOid(String oid) {
        return orderMapper.selectByPrimaryKey(oid);
    }

    @Override
    public List<Order> findOrderByUid(Integer uid) {
        return orderMapper.findOrderByUid(uid);
    }

    @Override
    public void delOrder(String itenId) {
        orderItemMapper.deleteByPrimaryKey(itenId);
    }
}

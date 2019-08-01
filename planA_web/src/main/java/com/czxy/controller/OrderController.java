package com.czxy.controller;

import com.czxy.domain.*;
import com.czxy.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author 黄开文
 * @Version v 1.0
 * @Date 2019/8/1
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/save")
    public ResponseEntity<Void> subOrder(HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("loginU");
        if (cart == null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (user == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Order order = new Order();
        order.setOrderTime(new Date());
        order.setOid(UUID.randomUUID().toString().replace("-",""));
        order.setUid(user.getUid());
        order.setOrderStatus(1);
        List<OrderItem> orderItemList = order.getOrderItemList();
        Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
        for (Integer key : cartItemMap.keySet()) {
            CartItem cartItem = cartItemMap.get(key);
            OrderItem orderItem = new OrderItem();

            orderItem.setOid(order.getOid());
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getCount());
            orderItem.setSubPrice(cartItem.getSubtotal());
            orderItem.setPid(cartItem.getProduct().getPid());
            orderItemList.add(orderItem);
        }
        order.setOrderItemList(orderItemList);
        orderService.saveOrder(order);
        session.removeAttribute("cart");
        session.setAttribute("oid",order.getOid());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getOid")
    public ResponseEntity<String> getOid(HttpSession session){
        String oid = (String) session.getAttribute("oid");
        session.removeAttribute("oid");
        return ResponseEntity.ok(oid);
    }

    @PutMapping("/address")
    public ResponseEntity<Void> saveAddress(Order order){
        try {
            orderService.updateAddress(order);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{oid}")
    public ResponseEntity<Order> findOrderByOid(@PathVariable("oid") String oid){
        Order order = orderService.findOrderByOid(oid);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/MyOrder/{uid}")
    public ResponseEntity<Order> findOrderByUid(@PathVariable("uid") Integer uid){
        Order order = orderService.findOrderByUid(uid);
        return ResponseEntity.ok(order);
    }
}

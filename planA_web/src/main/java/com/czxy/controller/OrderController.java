package com.czxy.controller;

import com.czxy.domain.*;
import com.czxy.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

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

    @PostMapping("/save")
    public ResponseEntity<Void> subOrder(HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("loginU");
        if (cart == null){
            System.out.println("购物车为空");
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
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
        for (Integer key : cartItemMap.keySet()) {
            CartItem cartItem = cartItemMap.get(key);
            OrderItem orderItem = new OrderItem();

            orderItem.setOid(order.getOid());
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getCount());
            orderItem.setSubPrice(cartItem.getSubtotal());
            orderItem.setPid(cartItem.getProduct().getPid());
            orderItems.add(orderItem);
        }
        order.setOrderItemList(orderItems);
        orderService.saveOrder(order);
        session.removeAttribute("cart");
        session.setAttribute("oid",order.getOid());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getOid")
    public ResponseEntity<String> getOid(HttpSession session){
        String oid = (String) session.getAttribute("oid");
        System.out.println(oid);
        return ResponseEntity.ok(oid);
    }

    @PutMapping("/address")
    public ResponseEntity<Void> saveAddress(Order order){
        try {
            System.out.println(order);
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
    public ResponseEntity<List<Order>> findOrderByUid(@PathVariable("uid") Integer uid){
        List<Order> orders =  orderService.findOrderByUid(uid);
        for (Order order : orders) {
            System.out.println(order);
        }
        return ResponseEntity.ok(orders);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> delOrder(@PathVariable("itemId") String itemId){
        try {
            orderService.delOrder(itemId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

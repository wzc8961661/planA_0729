package com.czxy.controller;


import com.czxy.domain.Cart;
import com.czxy.domain.Product;
import com.czxy.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Resource
    private CartService cartService;


    @PutMapping("/addCart/{pid}/{number}")
    public ResponseEntity<Void> addCart(@PathVariable("pid") Integer pid, @PathVariable("number") int number, HttpSession session) {
        try {
            //接收参数
            Integer count = 1;
            if (number != 0) {
                count = number;
            }
//		2.更新购物车
//		获取商品信息
            Product byPid = cartService.findByPid(pid);

            if (byPid == null) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);//500
            }

//		 从session  中获取购物车对象
            Cart cart = (Cart) session.getAttribute("cart");

//		防止清空购物车
            if (cart == null) {
                cart = new Cart();
            }


            System.out.println(count);
            cart.addCart(byPid, count);

            System.out.println(cart);
            System.out.println(cart.getCartItemMap().get(pid).getSubtotal());
            session.setAttribute("cart", cart);
            System.out.println(cart.getTotal());

            return new ResponseEntity<Void>(HttpStatus.CREATED);  //201

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);//500
        }
    }


    //	删除购物车的方法
    @DeleteMapping("/delete/{pid}")
    public ResponseEntity<Void> removeCartItem(@PathVariable("pid") Integer pid, HttpSession session) {
        try {
            Cart cart = (Cart) session.getAttribute("cart");
            cart.removerCartItem(pid);
            session.setAttribute("cart", cart);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);//500
        }
    }

    //	清空购物车
    @DeleteMapping("/clean")
    public ResponseEntity<Void> clearCart(HttpSession session) {
        try {
            Cart cart = (Cart) session.getAttribute("cart");
            cart.clean();
            session.removeAttribute("cart");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);//500
        }
    }


}

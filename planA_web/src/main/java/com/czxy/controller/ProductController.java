package com.czxy.controller;

import com.czxy.domain.Product;
import com.czxy.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Lenovo
 * @version v 1.0
 * @date 2019/7/31
 */
@RestController
@RequestMapping("/product")
public class ProductController{

    @Resource
    private ProductService productService;

    //查询所有商品
    @GetMapping
    public ResponseEntity<List<Product>>findProAll(){
        try {
            List<Product> productList = productService.findAll();
            return ResponseEntity.ok(productList);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //商品详情
    @GetMapping("/{id}")
    public ResponseEntity<Product> findByPid(@PathVariable("id") Integer id) {
        try {
            Product byPid = productService.findByPid(id);
            System.out.println(id);
            System.out.println(byPid);
            return ResponseEntity.ok(byPid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

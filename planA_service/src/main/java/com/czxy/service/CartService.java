package com.czxy.service;

import com.czxy.domain.Product;

public interface CartService {


    // 根据id找对应的商品信息
    Product findByPid(Integer pid);
}

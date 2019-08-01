package com.czxy.service.impl;


import com.czxy.dao.ProductMapper;
import com.czxy.domain.Product;
import com.czxy.service.CartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Resource
    private ProductMapper productMapper;


    @Override
    public Product findByPid(Integer pid) {
        Product product = productMapper.selectByPrimaryKey(pid);
        if (product != null) {
            return product;
        }
        return null;
    }
}

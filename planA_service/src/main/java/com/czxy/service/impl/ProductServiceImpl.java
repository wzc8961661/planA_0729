package com.czxy.service.impl;

import com.czxy.dao.ProductMapper;
import com.czxy.domain.Product;
import com.czxy.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Lenovo
 * @version v 1.0
 * @date 2019/7/31
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Resource
    private ProductMapper productMapper;

    //展示所有商品
    @Override
    public List<Product> findAll() {
        return productMapper.findAll();
    }

    //商品详情展示
    @Override
    public Product findByPid(Integer pid) {
        return productMapper.findByPid(pid);
    }
}

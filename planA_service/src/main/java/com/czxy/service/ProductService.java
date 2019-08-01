package com.czxy.service;

import com.czxy.domain.Product;

import java.util.List;

/**
 * @author Lenovo
 * @version v 1.0
 * @date 2019/7/31
 */
public interface ProductService {

    //模糊查询
    public List<Product> findProByPname(String pname);

    //展示所有商品
    public List<Product> findAll();

    //商品详情展示
    public Product findByPid(Integer pid);
}

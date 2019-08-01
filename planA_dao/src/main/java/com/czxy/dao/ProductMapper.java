package com.czxy.dao;

import com.czxy.domain.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Lenovo
 * @version v 1.0
 * @date 2019/7/31
 */
@org.apache.ibatis.annotations.Mapper
public interface ProductMapper extends Mapper<Product> {

    //模糊查询
    @Select("select * from product where pname like #{pname}")
    public List<Product> findProByPname(@Param("pname") String pname);

    // 查询所有商品
    @Select("select * from product")
    public List<Product> findAll();

    //商品详情展示
    @Select("select *  from product where pid=#{pid}")
    public Product findByPid(@Param("pid")Integer pid);
}

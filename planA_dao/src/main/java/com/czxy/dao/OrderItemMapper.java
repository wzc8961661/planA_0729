package com.czxy.dao;

import com.czxy.domain.OrderItem;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author 黄开文
 * @Version v 1.0
 * @Date 2019/8/1
 */
@org.apache.ibatis.annotations.Mapper
public interface OrderItemMapper extends Mapper<OrderItem> {


    @Select("select * from orderitem where oid = #{oid}")
    @Results({
            @Result(property = "product",one = @One(select = "com.czxy.dao.ProductMapper.selectByPrimaryKey"),column = "pid")
    })
    public List<OrderItem> findOIByOid(String oid);
}

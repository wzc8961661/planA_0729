package com.czxy.dao;

import com.czxy.domain.Order;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author 黄开文
 * @Version v 1.0
 * @Date 2019/8/1
 */
@org.apache.ibatis.annotations.Mapper
public interface OrderMapper extends Mapper<Order> {


    @Update("update `order` set address=#{address},name=#{name},telephone=#{telephone} where oid=#{oid}")
    public void saveAddress(Order order);


    @Select("select * from `order` where uid = #{uid}")
    @Results({
            @Result(property = "oid",column = "oid"),
            @Result(property = "orderItemList",column = "oid",many = @Many(select = "com.czxy.dao.OrderItemMapper.findOIByOid"))
    })
    public List<Order> findOrderByUid(Integer uid);
}

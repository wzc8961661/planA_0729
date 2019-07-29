package com.czxy.dao;

import com.czxy.domain.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author Lenovo
 * @version v 1.0
 * @date 2019/7/29
 */
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {

    //登录
    @Select("select * from user where phone=#{phone} and password=#{password}")
    public User login(User user);
}

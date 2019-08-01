package com.czxy.service.impl;

import com.czxy.dao.UserMapper;
import com.czxy.domain.User;
import com.czxy.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Lenovo
 * @version v 1.0
 * @date 2019/7/29
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    //登录
    @Override
    public User login(User user) {
        User login = userMapper.login(user);
        if (login !=null){
            return login;
        }
        return null;
    }


    //注册--校验手机号
    @Override
    public boolean checkPhone(String phone) {
        User user = userMapper.checkPhone(phone);
        if (user==null){
            return true;
        }
        return false;
    }

    //注册用户
    @Override
    public void register(User user) {
        userMapper.insert(user);
    }
}

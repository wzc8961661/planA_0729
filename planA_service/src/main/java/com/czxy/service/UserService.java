package com.czxy.service;

import com.czxy.domain.User;

/**
 * @author Lenovo
 * @version v 1.0
 * @date 2019/7/29
 */
public interface UserService {

    //登录
    public User login(User user);

    //注册用户
    public void register(User user);
}

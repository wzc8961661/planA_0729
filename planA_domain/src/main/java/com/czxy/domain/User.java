package com.czxy.domain;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lenovo
 * @version v 1.0
 * @date 2019/7/29
 */
@Table(name = "user")
public class User {

    @Id
    private Integer uid;//用户id
    private String phone;//手机号
    private String password;//密码
    private String username;//用户名

    public User() {
    }

    public User(Integer uid, String phone, String password, String username) {
        this.uid = uid;
        this.phone = phone;
        this.password = password;
        this.username = username;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

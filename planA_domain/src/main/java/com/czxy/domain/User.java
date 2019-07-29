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
    private String password;

    public User() {
    }

    public User(Integer uid, String phone, String password) {
        this.uid = uid;
        this.phone = phone;
        this.password = password;
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

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

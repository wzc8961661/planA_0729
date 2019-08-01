package com.czxy.controller;

import cn.itcast.vcode.VerifyCode;
import com.czxy.domain.User;
import com.czxy.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * @author Lenovo
 * @version v 1.0
 * @date 2019/7/29
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    //校验验证码
    @GetMapping("/checkCode/{vcCode}")
    public ResponseEntity<Boolean> checkCode(HttpSession session,@PathVariable("vcCode") String vcCode){
        String codeText = (String) session.getAttribute("codeText");
        if (codeText.equalsIgnoreCase(vcCode)){
            return ResponseEntity.ok(true);
        }else {
            return ResponseEntity.ok(false);
        }
    }


    //获取验证码
    @RequestMapping("/vcCode")
    public ResponseEntity<Void> getVc(HttpServletResponse response,HttpSession session){
        try {
            VerifyCode verifyCode = new VerifyCode();
            BufferedImage image = verifyCode.getImage();
            String text = verifyCode.getText();
            session.setAttribute("codeText", text);
            verifyCode.output(image, response.getOutputStream());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //登录
    @PostMapping("/login")
    public ResponseEntity login(User user, HttpSession session) {
        User login = userService.login(user);
        if (login != null) {
            session.setAttribute("loginU", login);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //注册--校验手机号
    @GetMapping("/{phone}")
    public ResponseEntity<Boolean> checkPhone(@PathVariable("phone") String phone){
        boolean rel = userService.checkPhone(phone);
        if (rel){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(false,HttpStatus.OK);
        }
    }


    //注册
    @PostMapping("/register")
    public ResponseEntity<Void> register(User user) {
        try {
            userService.register(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/findUser")
    public ResponseEntity<User> getUser(HttpSession session){
        User loginU = (User) session.getAttribute("loginU");
        if (loginU != null){
            return ResponseEntity.ok(loginU);
        }else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

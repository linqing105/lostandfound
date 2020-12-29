package com.evan.wj.controller;

import com.evan.wj.pojo.User;
import com.evan.wj.result.Result;
import com.evan.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession session) {
        String telno = requestUser.getTelno();
        telno = HtmlUtils.htmlEscape(telno);
        System.out.println("用户名为："+telno);
        User user = userService.Get(telno, requestUser.getPassword());
        if (null == user) {
            return new Result(400);
        } else {
//            session.setAttribute("user", user);
            return new Result(200);
        }

    }

    @CrossOrigin
    @PostMapping(value = "/api/register")
    @ResponseBody
    public Result register(@RequestBody User requestUser){
        String telno = requestUser.getTelno();
        telno=HtmlUtils.htmlEscape(telno);
        requestUser.setTelno(telno);

        String password=requestUser.getPassword();
        System.out.println("用户名为："+telno);
        System.out.println("用户名为："+password);
        boolean isExists=userService.isExists(telno);
        if(isExists){
            return new Result(400);
        }
//        String salt=new SecureRandomNumberGenerator().nextBytes().toString();
//        int times=2;
//        String algorithm ="md5";
//        String pedAfterHash=new SimpleHash(algorithm,password,salt,times).toString();
//
        userService.register(requestUser);
        return new Result(200);
    }

}
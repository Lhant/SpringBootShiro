package com.zqk.controller;

import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Security;

@Controller
public class userController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "ok";
    }


    @RequestMapping("/add")
    public String add(){
        return "user/add";
    }

    @RequestMapping("/update")
    public String update(){
        return "user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/noAuth")
    public String noAuth(){
        return "noAuth";
    }


    @RequestMapping("/testThymeleaf")
    public String testThymeleaf(Model model){

        return "test";
    }


    /**
     * 登录逻辑处理
    * */
    @RequestMapping("/login")
    public String login(String name,String password,Model model){

        /**
         * 使用Shiro编写认证操作
         */
        System.out.println("name:"+name);
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);

        try {
            //执行登陆方法
            subject.login(token);
            //登录成功
            //跳转到test.html
            return "redirect:/testThymeleaf";
        } catch (UnknownAccountException e) {
            //登录失败:用户名不存在
            model.addAttribute("msg", "用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e) {
            //登录失败:用户名不存在
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }


}

package com.yaoyuan.jiscuss.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {



    /**
     * 登录页面跳转
     * @return
     */
    @GetMapping("loginpage")
    public String loginpage() {
    	   return "login";
    }


    @RequestMapping("/world")
    public String world(Map<String, Object> model) {
        model.put("data","2019");
//        request.setAttribute("name", "xxxxxxxxx");
        model.put("msg",  "xxxxxxx2222xx");
        return "world";

    }
}
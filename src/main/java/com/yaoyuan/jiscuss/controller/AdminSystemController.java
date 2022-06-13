package com.yaoyuan.jiscuss.controller;

import com.yaoyuan.jiscuss.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yaoyuan2.chu
 * 后台系统控制器
 */
@Controller
public class AdminSystemController {

    /**
     * 后台登录
     */

    /**
     * 后台退出
     */

    /**
     * 后台设置管理
     */

    /**
     * 后台页面
     * @return
     */
    @RequestMapping("/admin/home")
    public String user(@RequestParam(defaultValue = "discussion") String type, HttpServletRequest request, ModelMap map) {
        return "admin/home";
    }
}

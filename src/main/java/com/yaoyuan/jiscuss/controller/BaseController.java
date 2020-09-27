package com.yaoyuan.jiscuss.controller;

import com.yaoyuan.jiscuss.entity.UserInfo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * @author yaoyuan2.chu
 * @Title: BaseController
 * @Package com.yaoyuan.jiscuss.controller
 * @Description: BaseController
 * @date 2020/7/16 14:36
 */
public class BaseController {

    /**
     * 获取当前用户
     *
     * @return
     */
    protected UserInfo getUserInfo(HttpServletRequest request) {
        UserInfo user = null;
        //获得session对象
        HttpSession session = request.getSession();
        //取出session域中所有属性名
        Enumeration attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            System.out.println(attributeNames.nextElement());
        }
        //SPRING_SECURITY_CONTEXT
        Object spring_security_context = session.getAttribute("SPRING_SECURITY_CONTEXT");
        System.out.println(spring_security_context);
        SecurityContext securityContext = (SecurityContext) spring_security_context;
        if (securityContext != null) {
            //获得认证信息
            Authentication authentication = securityContext.getAuthentication();
            //获得用户详情
            Object principal = authentication.getPrincipal();
            user = (UserInfo) principal;
        }
        return user;
    }

}

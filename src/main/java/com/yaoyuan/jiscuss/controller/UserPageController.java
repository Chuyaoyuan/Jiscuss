package com.yaoyuan.jiscuss.controller;

import com.yaoyuan.jiscuss.entity.Discussion;
import com.yaoyuan.jiscuss.entity.Tag;
import com.yaoyuan.jiscuss.entity.User;
import com.yaoyuan.jiscuss.entity.UserInfo;
import com.yaoyuan.jiscuss.entity.custom.DiscussionCustom;
import com.yaoyuan.jiscuss.entity.custom.TagCustom;
import com.yaoyuan.jiscuss.service.IDiscussionsService;
import com.yaoyuan.jiscuss.service.ITagsService;
import com.yaoyuan.jiscuss.service.IUsersService;
import com.yaoyuan.jiscuss.util.DelTagsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author yaoyuan2.chu
 * @Title:
 * @Package com.yaoyuan.jiscuss.controller
 * @Description:
 * @date
 */
@Controller
public class UserPageController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(UserPageController.class);

    @Autowired
    private IUsersService usersService;

    @Autowired
    private IDiscussionsService discussionsService;

    @Autowired
    private ITagsService tagsService;


    /**
     * 用户页面
     *
     * @return
     */
    @RequestMapping("/user")
    public String user(@RequestParam(defaultValue = "discussion") String type, HttpServletRequest request, ModelMap map) {

        if (type.equals("discussion")) {
            map.put("discussion", "active");
        }
        if (type.equals("change")) {
            map.put("change", "active");
        }
        if (type.equals("like")) {
            map.put("like", "active");
        }

        UserInfo user = getUserInfo(request);
        if (user != null) {
            map.put("username", user.getUsername());
            map.put("data", "Jiscuss 用户:" + user.getUsername());
        }
        return "user";
    }
}

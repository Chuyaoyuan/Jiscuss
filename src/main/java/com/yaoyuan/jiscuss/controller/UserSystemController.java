package com.yaoyuan.jiscuss.controller;

import com.yaoyuan.jiscuss.entity.Discussions;
import com.yaoyuan.jiscuss.entity.Tags;
import com.yaoyuan.jiscuss.entity.Users;
import com.yaoyuan.jiscuss.service.IDiscussionsService;
import com.yaoyuan.jiscuss.service.ITagsService;
import com.yaoyuan.jiscuss.service.IUsersService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * 用户页面系统控制器
 */
@Controller
public class UserSystemController {

    private static Logger logger = LoggerFactory.getLogger(UserSystemController.class);

    @Autowired
    private IUsersService usersService;

    @Autowired
    private IDiscussionsService discussionsService;
    
    @Autowired
    private ITagsService tagsService;

    //首页
    @RequestMapping("/")
    public String home(HttpServletRequest request,Map<String, Object> map) {
        logger.info(">>> index");
        List<Users> userall = usersService.getAllList();
        logger.info(">>> 第一遍的全部用户："+userall);
        
        List<Users> useral2 = usersService.getAllList();
        logger.info(">>> 第二遍的全部用户："+useral2);

        String username ="";
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
        if(securityContext!=null){
            //获得认证信息
            Authentication authentication = securityContext.getAuthentication();
            //获得用户详情
            Object principal = authentication.getPrincipal();
            User user = (User) principal;
            username = user.getUsername();
            System.out.println(username);
        }

        //分页获取主题帖子
//        List<Discussions> allDiscussions = discussionsService.getAllList();
        
        Page<Discussions> allDiscussionsPage = discussionsService.queryAllDiscussionsList(0,20);
        
        List<Discussions> allDiscussions =allDiscussionsPage.getContent();
        
        logger.info("全部主题==>：{}",allDiscussions);
        
        //获取主题帖子的分页数据
        List<String>  pageNumList = getPageNumList(allDiscussionsPage.getTotalPages());

        //获取所有标签（以后尝试去缓存中取） 
        List<Tags> allTags = tagsService.getAllList();
        logger.info("全部标签==>：{}",allTags);
        
        System.out.println(userall.toString());
        map.put("data", "Jiscuss 用户");
        map.put("allDiscussions", allDiscussions);
        map.put("pageDiscussions", pageNumList);
        map.put("allTags", allTags);
        map.put("username", username);
        return "index";
    }

    
    private List<String>  getPageNumList(int size) {
    	List<String> pageNumList  = new ArrayList<String>();
		if(size>5) {
			pageNumList.add("1");
			pageNumList.add("2");
			pageNumList.add("...");
			pageNumList.add(""+(size-1));
			pageNumList.add(""+(size));
			
		}else {
			for(int  i = 0;i<size;i++) {
				pageNumList.add(""+(i+1));
			}
		}
		return pageNumList;
	}


	//登录
//    @PostMapping(value = "/login")
//    @ResponseBody
//    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
//                        HttpSession session) {
//        JSONObject resultobj = new JSONObject();
//        Users user = usersService.checkByUsernameAndPassword(username, password);
//        if (user!=null) {
//            //用户名和密码完成校验
//            session.setAttribute("username", username);  //缓存session
//            session.setAttribute("userid", user.getId());  //缓存session
//            resultobj.put("username", username);
//            resultobj.put("msg", "登录成功");
//            resultobj.put("flag", true);
//        } else {
//            //用户名和密码未完成校验
//            resultobj.put("msg", "用户名或密码错误");
//            resultobj.put("flag", false);
//        }
//        return resultobj.toString();
//    }

    //登录页
    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout,Map<String, Object> map) {
        if (error != null) {
            map.put("msg", "您输入的用户名密码错误！");
            return "login";
        }
        if (logout != null) {
            map.put("msg", "退出成功！");
            return "login";
        }

        return "login";
    }

    //退出
    @PostMapping(value = "/loginout")
    @ResponseBody
    public String logout(HttpServletRequest request, HttpServletResponse response){
        JSONObject resultobj = new JSONObject();
        HttpSession session=request.getSession();
        session.invalidate();
        resultobj.put("msg", "用户退出成功");
        resultobj.put("flag", true);
        return resultobj.toString(); //
    }

    //注册

    //获取设置信息

    //获取首页统计
}

package com.yaoyuan.jiscuss.controller;

import com.yaoyuan.jiscuss.entity.Discussion;
import com.yaoyuan.jiscuss.entity.Tag;
import com.yaoyuan.jiscuss.entity.UserInfo;
import com.yaoyuan.jiscuss.entity.User;
import com.yaoyuan.jiscuss.entity.custom.DiscussionCustom;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户页面系统控制器
 */
@Controller
public class UserSystemController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(UserSystemController.class);

    @Autowired
    private IUsersService usersService;

    @Autowired
    private IDiscussionsService discussionsService;
    
    @Autowired
    private ITagsService tagsService;

    //首页
    @RequestMapping({"/","/main","/index"})
    public String home(@RequestParam(defaultValue = "all") String tag, @RequestParam(defaultValue = "all") String type,@RequestParam(defaultValue = "1") Integer
            pageNum, HttpServletRequest request, ModelMap map) {
        logger.info(">>> index");
        logger.info(">>> tag:" + tag);
        logger.info(">>> pageNum:" + pageNum);
        List<User> userall = usersService.getAllList();
        logger.info(">>> 第一遍的全部用户："+userall);
        
        List<User> useral2 = usersService.getAllList();
        logger.info(">>> 第二遍的全部用户："+useral2);

        int pageSiz = 10;
        int pageNumNew = pageNum - 1;
        Discussion discussion = new Discussion();
        //分页获取主题帖子
        Page<Discussion> allDiscussionsPage = discussionsService.queryAllDiscussionsList(discussion,pageNumNew,pageSiz);
        
        List<Discussion> allDiscussions = allDiscussionsPage.getContent();
        List<DiscussionCustom> newAllD = new ArrayList<>();

        for (Discussion dd : allDiscussions){
            DiscussionCustom newdd = new DiscussionCustom();
            BeanUtils.copyProperties(dd , newdd);
            String newCon = "";
            String content = DelTagsUtil.getTextFromHtml(newdd.getContent());
            if(null != content && content.length()>30){
                newCon = content.substring(0,29);
            }else{
                newCon = content;
            }
            newdd.setContent(newCon);
            if (null != newdd.getStartUserId()){
                User startUser = usersService.findOne(newdd.getStartUserId());
                newdd.setAvatar(startUser.getAvatar());
                newdd.setRealname(startUser.getRealname());
                newdd.setUsername(startUser.getUsername());
            }
            if (null != newdd.getLastUserId()){
                User lastUser = usersService.findOne(newdd.getLastUserId());
                newdd.setAvatarLast(lastUser.getAvatar());
                newdd.setRealnameLast(lastUser.getRealname());
                newdd.setUsernameLast(lastUser.getUsername());
            }

            newAllD.add(newdd);
        }
        
        logger.info("全部主题==>：{}",allDiscussions);

        Long total = allDiscussionsPage.getTotalElements();
        
        //获取主题帖子的分页数据
        List<String>  pageNumList = getPageNumList(allDiscussionsPage.getTotalPages());

        //获取所有标签（以后尝试去缓存中取） 
        List<Tag> allTags = tagsService.getAllList();
        logger.info("全部标签==>：{}",allTags);
        
        System.out.println(userall.toString());
        map.put("data", "Jiscuss 用户");
        map.put("allDiscussions", newAllD);
        map.put("pageDiscussions", pageNumList);
        map.put("allTags", allTags);
        map.put("tag", tag);
        map.put("type", type);

        map.put("pageSize",pageSiz);
        map.put("pageTotal", total);
        map.put("pageNum", pageNum);
        map.put("pageTotalPages", allDiscussionsPage.getTotalPages());
        UserInfo user = getUserInfo(request);
        if(user != null){
            map.put("username", user.getUsername());
            map.put("data", "Jiscuss 用户:" + user.getUsername());
        }
        return "index";
    }

    
    private List<String>  getPageNumList(int size) {
    	List<String> pageNumList  = new ArrayList<String>();
        for(int  i = 0;i<size;i++) {
            pageNumList.add(""+(i+1));
        }
		return pageNumList;
	}


    //登录页
    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout,ModelMap map) {
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


    //注册

    //获取设置信息

    //获取首页统计
}

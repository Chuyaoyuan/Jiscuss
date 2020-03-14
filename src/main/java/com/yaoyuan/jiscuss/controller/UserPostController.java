package com.yaoyuan.jiscuss.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.yaoyuan.jiscuss.entity.Discussions;
import com.yaoyuan.jiscuss.entity.Tags;
import com.yaoyuan.jiscuss.service.IDiscussionsService;
import com.yaoyuan.jiscuss.service.ITagsService;

/**
 * 主题帖子评论控制器
 */
@Controller
public class UserPostController {
	
	private static Logger logger = LoggerFactory.getLogger(UserPostController.class);


    @Autowired
    private IDiscussionsService discussionsService;
    
    @Autowired
    private ITagsService tagsService;
    

    
    //首页查看主题列表（各种条件筛选，最热最新标签等）
    
    

	//查看主题详情
    @RequestMapping("/getdiscussionsbyid")
    public String getDiscussionsById(HttpServletRequest request,Map<String, Object> map,@RequestParam("id") Integer id) {
        logger.info(">>> getDiscussionsById{}",id);

        Discussions discussions = discussionsService.findOne(id);
        HttpSession session=request.getSession();
        map.put("discussions", discussions);
        map.put("username", session.getAttribute("username"));
        return "discussions";
    }

	
    //新建主题
    @PostMapping(value = "/newdiscussions")
    @ResponseBody
    public String newDiscussions(@RequestBody Discussions discussions) {
        logger.info(">>> newPost"+discussions);

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        
        HttpSession session=request.getSession();
        discussions.setLast_user_id( (Integer)session.getAttribute("userid"));
        discussions.setCreate_id( (Integer)session.getAttribute("userid"));
        discussions.setCreate_time(new Date());
        
        Discussions saveDiscussions = discussionsService.insert(discussions);
        JSONObject resultobj = new JSONObject();
       
        logger.info(">>>{}",saveDiscussions );
        resultobj.put("msg", "添加成功");
        resultobj.put("flag", true);
        return resultobj.toString(); //
   
    }


    //编辑主题

    //删除主题

    //新建评论

    //删除评论
    
    //新建标签
    @PostMapping(value = "/newtags")
    @ResponseBody
    public String newTags(@RequestBody Tags tags) {
        logger.info(">>> newTags"+tags);

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        
        HttpSession session=request.getSession();
        tags.setCreate_id( (Integer)session.getAttribute("userid"));
        tags.setCreate_time(new Date());
        
        Tags saveTags = tagsService.insert(tags);
        JSONObject resultobj = new JSONObject();
       
        logger.info(">>>{}",saveTags );
        resultobj.put("msg", "添加成功");
        resultobj.put("flag", true);
        return resultobj.toString(); //
   
    }

    //排行榜等
}

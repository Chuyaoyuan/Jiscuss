package com.yaoyuan.jiscuss.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.yaoyuan.jiscuss.entity.*;
import com.yaoyuan.jiscuss.entity.custom.DiscussionCustom;
import com.yaoyuan.jiscuss.entity.custom.PostCustom;
import com.yaoyuan.jiscuss.service.*;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 主题帖子评论控制器
 */
@Controller
public class UserPostController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(UserPostController.class);


    @Autowired
    private IDiscussionsService discussionsService;

    @Autowired
    private ITagsService tagsService;

    @Autowired
    private IDiscussionsTagsService iDiscussionsTagsService;

    @Autowired
    private IPostsService postsService;

    @Autowired
    private IUsersService usersService;


    //首页查看主题列表（各种条件筛选，最热最新标签等）


    //查看主题详情
    @RequestMapping("/getdiscussionsbyid")
    public String getDiscussionsById(HttpServletRequest request, ModelMap map, @RequestParam("id") Integer id) {
        logger.info(">>> getDiscussionsById{}", id);

        Discussion discussion = discussionsService.findOne(id);
        // 获取此主题下的评论
        List<Post> posts = postsService.findOneBy(id);

        DiscussionCustom newdd = new DiscussionCustom();
        BeanUtils.copyProperties(discussion, newdd);
        if (null != newdd.getStartUserId()) {
            User startUser = usersService.findOne(newdd.getStartUserId());
            newdd.setAvatar(startUser.getAvatar());
            newdd.setRealname(startUser.getRealname());
            newdd.setUsername(startUser.getUsername());
        }
        if (null != newdd.getLastUserId()) {
            User lastUser = usersService.findOne(newdd.getLastUserId());
            newdd.setAvatarLast(lastUser.getAvatar());
            newdd.setRealnameLast(lastUser.getRealname());
            newdd.setUsernameLast(lastUser.getUsername());
        }


        List<Tag> tags = tagsService.findByDId(id);

        List postsObj = postsService.findPostCustomById(id);

        map.put("tags", tags);

        map.put("discussions", newdd);
        map.put("posts", postsObj);
        UserInfo user = getUserInfo(request);
        if (user != null) {
            map.put("username", user.getUsername());
        }
        return "discussions";
    }


    //新建主题
    @PostMapping(value = "/newdiscussions")
    @ResponseBody
    public String newDiscussions(@RequestBody DiscussionCustom discussion) {
        logger.info(">>> newPost" + discussion);

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        UserInfo user = getUserInfo(request);
        if (user != null) {
            discussion.setStartUserId(user.getId());
            discussion.setLastUserId(user.getId());
            discussion.setCreateId(user.getId());
        }


        discussion.setCreateTime(new Date());
        discussion.setStartTime(new Date());
        discussion.setLastTime(new Date());

        Discussion discussionOne = new Discussion();
        BeanUtils.copyProperties(discussion, discussionOne);

        Discussion saveDiscussion = discussionsService.insert(discussionOne);

        if (null != discussion.getTag()) {
            //执行组装标签
            String[] strArray = discussion.getTag().split(",");
            for(String str : strArray){
                DiscussionTag dtag= new DiscussionTag();
                dtag.setDiscussionId(saveDiscussion.getId());
                dtag.setTagId(Integer.parseInt(str));
                iDiscussionsTagsService.insert(dtag);
            }
        }

        JSONObject resultobj = new JSONObject();

        logger.info(">>>{}", saveDiscussion);
        resultobj.put("msg", "添加成功");
        resultobj.put("flag", true);
        return resultobj.toString(); //

    }


    //编辑主题

    //删除主题

    //新建评论
    @PostMapping(value = "/newpost")
    @ResponseBody
    public String newPosts(@RequestBody Post post) {
        logger.info(">>> newpost" + post);

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();

        UserInfo user = getUserInfo(request);
        if (user != null) {
            post.setCreateId(user.getId());
        }
        post.setCreateTime(new Date());
        if (null != post.getParentId()) {
            Post temp = postsService.findOneByid(post.getParentId());
            post.setUserId(temp.getCreateId());

        }

        Post savePost = postsService.insert(post);
        JSONObject resultobj = new JSONObject();

        logger.info(">>>{}", savePost);
        resultobj.put("msg", "添加成功");
        resultobj.put("flag", true);
        return resultobj.toString(); //
    }

    //删除评论

    //新建标签
    @PostMapping(value = "/newtags")
    @ResponseBody
    public String newTags(@RequestBody Tag tag) {
        logger.info(">>> newTags" + tag);

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();

        UserInfo user = getUserInfo(request);
        if (user != null) {
            tag.setCreateId(user.getId());
        }
        tag.setCreateTime(new Date());

        Tag saveTag = tagsService.insert(tag);
        JSONObject resultobj = new JSONObject();

        logger.info(">>>{}", saveTag);
        resultobj.put("msg", "添加成功");
        resultobj.put("flag", true);
        return resultobj.toString(); //

    }

    //排行榜等
}

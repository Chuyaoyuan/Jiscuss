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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页页面系统控制器
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

    /**
     * 首页index
     *
     * @param tag
     * @param type
     * @param pageNum
     * @param request
     * @param map
     * @return
     */
    @RequestMapping({"/", "/main", "/index"})
    public String home(@RequestParam(defaultValue = "all") String tag, @RequestParam(defaultValue = "all") String type,
                       @RequestParam(defaultValue = "1") Integer pageNum, HttpServletRequest request, ModelMap map) {
        logger.info(">>> index");
        logger.info(">>> tag:" + tag);
        logger.info(">>> pageNum:" + pageNum);

        int pageSiz = 10;
        int pageNumNew = pageNum - 1;
        Discussion discussion = new Discussion();
        //分页获取主题帖子-默认
        Page<Discussion> allDiscussionsPage = discussionsService.queryAllDiscussionsList(discussion, pageNumNew, pageSiz, tag, type);

        List<Discussion> allDiscussions = allDiscussionsPage.getContent();
        List<DiscussionCustom> newAllD = new ArrayList<>();

        setTagAndUserList(newAllD, allDiscussions);

        logger.info("全部主题==>：{}", allDiscussions);

        Long total = allDiscussionsPage.getTotalElements();

        //获取主题帖子的分页数据
        List<String> pageNumList = getPageNumList(allDiscussionsPage.getTotalPages());

        //获取所有标签（以后尝试去缓存中取） 
        List<Tag> allTags = tagsService.getAllList();
        logger.info("全部标签==>：{}", allTags);

        if (!tag.equals("all")) {
            //获取是否有子标签
            List<Tag> allChildTags = tagsService.findByParentId(tag);
            map.put("allChildTags", allChildTags);
        }

        map.put("data", "Jiscuss 用户");
        map.put("allDiscussions", newAllD);
        map.put("allUser", usersService.getAllList());
        map.put("pageDiscussions", pageNumList);
        map.put("allTags", allTags);
        map.put("tag", tag);
        map.put("type", type);

        if (type.equals("all")) {
            map.put("typeAll", "active");
        }
        if (type.equals("hot")) {
            map.put("typeHot", "active");
        }
        if (type.equals("new")) {
            map.put("typeNew", "active");
        }
        map.put("pageSize", pageSiz);
        map.put("pageTotal", total);
        map.put("pageNum", pageNum);
        map.put("pageTotalPages", allDiscussionsPage.getTotalPages());
        UserInfo user = getUserInfo(request);
        if (user != null) {
            map.put("username", user.getUsername());
            map.put("data", "Jiscuss 用户:" + user.getUsername());
        }
        return "index";
    }

    /**
     * 组装DiscussionCustom
     *
     * @param newAllD
     * @param allDiscussions
     */
    private void setTagAndUserList(List<DiscussionCustom> newAllD, List<Discussion> allDiscussions) {

        List<Integer> discussionIdLsit = new ArrayList<>();
        for (Discussion dd : allDiscussions) {
            discussionIdLsit.add(dd.getId());
        }
        List<TagCustom> TagCustomList = tagsService.findByDiscussionIdlistId(discussionIdLsit);

        Map<Integer, List<TagCustom>> tagMap = new HashMap<>();
        for (TagCustom tc : TagCustomList) {
            List<TagCustom> tagCustomListTemp = new ArrayList<>();
            if (tagMap.containsKey(tc.getDiscussionId())) {
                tagCustomListTemp = tagMap.get(tc.getDiscussionId());
                tagCustomListTemp.add(tc);
                tagMap.put(tc.getDiscussionId(), tagCustomListTemp);
            } else {
                tagCustomListTemp.add(tc);
                tagMap.put(tc.getDiscussionId(), tagCustomListTemp);
            }
        }
        for (Discussion dd : allDiscussions) {
            DiscussionCustom newdd = new DiscussionCustom();
            BeanUtils.copyProperties(dd, newdd);
            String newCon = "";
            String content = DelTagsUtil.getTextFromHtml(newdd.getContent());
            if (null != content && content.length() > 30) {
                newCon = content.substring(0, 29);
            } else {
                newCon = content;
            }
            newdd.setContent(newCon);
            if (null != newdd.getStartUserId()) {
                User startUser = usersService.findOne(newdd.getStartUserId());
                newdd.setAvatar(startUser != null && startUser.getAvatar() != null ? startUser.getAvatar() : "");
                newdd.setRealname(startUser != null && startUser.getRealname() != null ? startUser.getRealname() : "");
                newdd.setUsername(startUser != null && startUser.getUsername() != null ? startUser.getUsername() : "");
            }
            if (null != newdd.getLastUserId()) {
                User lastUser = usersService.findOne(newdd.getLastUserId());
                newdd.setAvatarLast(lastUser != null && lastUser.getAvatar() != null ? lastUser.getAvatar() : "");
                newdd.setRealnameLast(lastUser != null && lastUser.getRealname() != null ? lastUser.getRealname() : "");
                newdd.setUsernameLast(lastUser != null && lastUser.getUsername() != null ? lastUser.getUsername() : "");
            }
            //组装tag
            newdd.setTagList(tagMap.get(dd.getId()));
            newAllD.add(newdd);
        }
    }

    /**
     * 分页信息
     *
     * @param size
     * @return
     */
    private List<String> getPageNumList(int size) {
        List<String> pageNumList = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            pageNumList.add("" + (i + 1));
        }
        return pageNumList;
    }


    /**
     * 登录页
     *
     * @param error
     * @param logout
     * @param map
     * @return
     */
    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout, ModelMap map) {
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


    /**
     * 注册提交
     *
     * @param username
     * @param email
     * @param password
     * @param map
     * @return
     */
    @PostMapping("/registerDo")
    public String registerDo(@RequestParam String username, @RequestParam String email,
                             @RequestParam String password, ModelMap map) {
        //验证用户名是否存在
        if (null != usersService.getByUsername(username)) {
            map.put("msg", "用户已存在，请重试！");
            return "register";
        } else {
            User user = new User();

            user.setEmail(email);
            user.setPassword(password);
            user.setUsername(username);
            user.setRealname(username);
            user.setJoinTime(new Date());
            User userInsert = usersService.insert(user);
            map.put("msg", "注册成功，请登陆！");
            return "login";
        }
    }

    /**
     * 注册页面
     *
     * @return
     */
    @RequestMapping("/register")
    public String register() {
        return "register";
    }


    //获取设置信息

    //获取首页统计
}

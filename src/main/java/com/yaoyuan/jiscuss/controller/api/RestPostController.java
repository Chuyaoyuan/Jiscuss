package com.yaoyuan.jiscuss.controller.api;

import com.yaoyuan.jiscuss.entity.Discussion;
import com.yaoyuan.jiscuss.exception.BaseException;
import com.yaoyuan.jiscuss.response.ResponseCode;
import com.yaoyuan.jiscuss.service.IDiscussionsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/other_api", produces = "application/json;charset=utf-8")
@Api(value = "主题帖子(其他)接口管理", tags = {"主题帖子(其他)接口管理"})
public class RestPostController {
    private static Logger logger = LoggerFactory.getLogger(RestPostController.class);

    @Autowired
    private IDiscussionsService discussionsService;

    @PostMapping("/discussion")
    @ApiOperation("新增主题")
    public Discussion save(@RequestBody Discussion discussion) {
        Discussion saveDiscussion = discussionsService.insert(discussion);
        if (saveDiscussion != null) {
            return saveDiscussion;
        } else {
            throw new BaseException(ResponseCode.RESOURCES_NOT_EXIST);
        }
    }

    @GetMapping("/discussion/{id}")
    @ApiOperation("获取主题")
    public Discussion getDiscussions(@PathVariable Integer id) {
        Discussion discussion = discussionsService.findOne(id);
        return discussion;
    }

    @GetMapping("/discussions")
    @ApiOperation("获取全部主题")
    public List<Discussion> getAllDiscussions() {
        List<Discussion> allDiscussions = discussionsService.getAllList();
        logger.info("全部主题==>：{}", allDiscussions);
        return allDiscussions;
    }

}

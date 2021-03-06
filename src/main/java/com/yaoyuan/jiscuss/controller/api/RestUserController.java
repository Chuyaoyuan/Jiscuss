package com.yaoyuan.jiscuss.controller.api;

import com.yaoyuan.jiscuss.entity.User;
import com.yaoyuan.jiscuss.exception.BaseException;
import com.yaoyuan.jiscuss.response.ResponseCode;
import com.yaoyuan.jiscuss.service.IUsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user_api")
@Api(value = "用户接口管理", tags = {"用户接口管理"})
public class RestUserController {

    private static Logger logger = LoggerFactory.getLogger(RestUserController.class);

    @Autowired
    private IUsersService usersService;

    @PostMapping("/user")
    @ApiOperation("新增用户")
    public User save(@RequestBody User user) {
        User saveUser = usersService.insert(user);
        if (saveUser != null) {
            return saveUser;
        } else {
            throw new BaseException(ResponseCode.RESOURCES_NOT_EXIST);
        }

    }

    @DeleteMapping("/user/{id}")
    @ApiOperation("删除用户")
    public Boolean delete(@PathVariable Integer id) {
        Boolean delete = true;
        usersService.remove(id);
        if (delete) {
            return delete;
        } else {
            throw new BaseException(ResponseCode.RESOURCES_NOT_EXIST);
        }
    }

    @PutMapping("/user/{id}")
    @ApiOperation("修改用户")
    public User update(@RequestBody User user, @PathVariable Integer id) {
        User updateuser = usersService.update(user, id);
        if (updateuser != null) {
            return updateuser;
        } else {
            throw new BaseException(ResponseCode.RESOURCES_NOT_EXIST);
        }
    }

    @GetMapping("/user/{id}")
    @ApiOperation("获取用户")
    public User getUser(@PathVariable Integer id) {
        User user = usersService.findOne(id);
        return user;
    }

    @GetMapping("/user")
    @ApiOperation("获取全部用户")
    public List<User> getUser(User user) {
        List<User> userall = usersService.getAllList();
        logger.info("全部用户==>：{}", userall);
        return userall;
    }

}

package com.yaoyuan.jiscuss.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.yaoyuan.jiscuss.entity.User;

public interface IUsersService {

    List<User> getAllList();

    Page<User> queryAllUsersList(int pageNum, int pageSize);

    List<User> getByUsernameIsLike(String name);

    //    @Cacheable("myCache")
    User findOne(Integer id);

    User insert(User user);

    void remove(Integer id);

    void deleteAll();

    User getByUsername(String username);

    User checkByUsernameAndPassword(String username, String password);

    User update(User user, Integer id);

}

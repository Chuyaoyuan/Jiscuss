package com.yaoyuan.jiscuss.service;

import com.yaoyuan.jiscuss.entity.User;
import org.springframework.data.domain.Page;
import java.util.List;

public interface IUsersService {

    List<User> getAllList();

    Page<User> queryAllUsersList(int pageNum, int pageSize);

    //Cacheable
    List<User> getByUsernameIsLike(String name);

    //@Cacheable("myCache")
    User findOne(Integer id);

    User insert(User user);

    void remove(Integer id);

    void deleteAll();

    User getByUsername(String username);

    User checkByUsernameAndPassword(String username, String password);

    User update(User user, Integer id);
}

package com.yaoyuan.jiscuss.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.yaoyuan.jiscuss.entity.Users;

public interface IUsersService {

    List<Users> getAllList();

    Page<Users> queryAllUsersList(int pageNum,int pageSize);

    List<Users> getByUsernameIsLike(String name);
 
//    @Cacheable("myCache")
    Users findOne(Integer id);

    Users insert(Users user);

    void remove(Integer id);

    void deleteAll();
    
	Users getByUsername(String username);

	Users checkByUsernameAndPassword(String username, String password);

    Users update(Users user, Integer id);

}

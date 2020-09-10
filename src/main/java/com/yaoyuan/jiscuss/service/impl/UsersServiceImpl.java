package com.yaoyuan.jiscuss.service.impl;




import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import com.yaoyuan.jiscuss.entity.User;
import com.yaoyuan.jiscuss.repository.UsersRepository;
import com.yaoyuan.jiscuss.service.IUsersService;
 
@Service
@Transactional
public class UsersServiceImpl implements IUsersService {
    @Autowired
    private UsersRepository usersRepository;

    /**
     * 获取全部用户
     * @return
     */
    @Cacheable(value = "user")
    @Override
    public List<User> getAllList() {
        return usersRepository.findAll();
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Page<User> queryAllUsersList(int pageNum, int pageSize) {
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        @SuppressWarnings("deprecation")
		Pageable pageable=new PageRequest(pageNum,pageSize,sort);
        return usersRepository.findAll(pageable);
    }

    /**
     * 根据名称模糊查询
     * @param name
     * @return
     */
    @Override
    public List<User> getByUsernameIsLike(String name) {
        return usersRepository.getByUsernameIsLike(name);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Cacheable(value = "user", key = "#id")
    @Override
    public User findOne(Integer id) {
        return usersRepository.getById(id);
    }

    /**
     * 新增
     * @param user
     * @return
     */
    @CachePut(value = "user", key = "#user.id")
    @Override
    public User insert(User user) {
        return usersRepository.save(user);
    }

    /**
     * 更新修改
     * @param user
     * @param id
     * @return
     */
    @CachePut(value = "user", key = "#user.id")
    @Override
    public User update(User user, Integer id) {
        return usersRepository.saveAndFlush(user);
    }

    /**
     * 移除
     * @param id
     */
    @CacheEvict(value = "user", key = "#id")
    @Override
    public void remove(Integer id) {
    	usersRepository.deleteById(id);
    }

    /**
     * 删除所有
     */
    @Override
    public void deleteAll() {
    	usersRepository.deleteAll();
    }

    /**
     * 根据名称查询
     * @param username
     * @return
     */
	@Override
	public User getByUsername(String username) {
		return usersRepository.getByUsername(username);
	}

    /**
     * 验证用户名密码
     * @param username
     * @param password
     * @return
     */
	@Override
	public User checkByUsernameAndPassword(String username, String password) {
		return usersRepository.checkByUsernameAndPassword(username,password);
	}


}


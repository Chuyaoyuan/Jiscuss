package com.yaoyuan.jiscuss.service.impl;




import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import com.yaoyuan.jiscuss.entity.Users;
import com.yaoyuan.jiscuss.repository.UsersRepository;
import com.yaoyuan.jiscuss.service.IUsersService;
 
@Service
@Transactional
public class UsersServiceImpl implements IUsersService {
    @Autowired
    private UsersRepository usersRepository;
 
    @Cacheable(value = "user")
    @Override
    public List<Users> getAllList() {
        return usersRepository.findAll();
    }
 

    @Override
    public Page<Users> queryAllUsersList(int pageNum,int pageSize) {
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        @SuppressWarnings("deprecation")
		Pageable pageable=new PageRequest(pageNum,pageSize,sort);
        return usersRepository.findAll(pageable);
    }
 
    @Override
    public List<Users> getByUsernameIsLike(String name) {
        return usersRepository.getByUsernameIsLike(name);
    }
 
    @Override
    public Users findOne(Integer id) {
        return usersRepository.getById(id);
    }
 
    @Override
    public Users insert(Users user) {
        return usersRepository.save(user);
    }
 
    @Override
    public void remove(Integer id) {
    	usersRepository.deleteById(id);
    }
 
    @Override
    public void deleteAll() {
    	usersRepository.deleteAll();
    }

	@Override
	public Users getByUsername(String username) {
		return usersRepository.getByUsername(username);
	}
	

	@Override
	public Users checkByUsernameAndPassword(String username,String password) {
		return usersRepository.checkByUsernameAndPassword(username,password);
	}


    @Override
    public Users update(Users user, Integer id) {
        return usersRepository.saveAndFlush(user);
    }

}


package com.yaoyuan.jiscuss.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.yaoyuan.jiscuss.entity.Staff;
 
public interface IStaffService {
    List<Staff> getAllList();
    Page<Staff> queryAllStaffList(int pageNum,int pageSize);
    List<Staff> getByNameIsLike(String name);
 
//    @Cacheable("myCache")
    Staff findOne(Integer id);
 

    Staff insert(Staff staff);

    
    void remove(Integer id);
 
 
    void deleteAll();
}

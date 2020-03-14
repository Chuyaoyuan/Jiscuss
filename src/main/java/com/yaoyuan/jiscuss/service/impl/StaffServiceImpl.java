package com.yaoyuan.jiscuss.service.impl;




import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.yaoyuan.jiscuss.entity.Staff;
import com.yaoyuan.jiscuss.repository.StaffRepository;
import com.yaoyuan.jiscuss.service.IStaffService;
 
@Service
@Transactional
public class StaffServiceImpl implements IStaffService {
    @Autowired
    private StaffRepository staffRepository;
 
    @Override
    public List<Staff> getAllList() {
        return staffRepository.findAll();
    }
 
    @Override
    public Page<Staff> queryAllStaffList(int pageNum,int pageSize) {
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        @SuppressWarnings("deprecation")
		Pageable pageable=new PageRequest(pageNum,pageSize,sort);
        return staffRepository.findAll(pageable);
    }
 
    @Override
    public List<Staff> getByNameIsLike(String name) {
        return staffRepository.getByNameIsLike(name);
    }
 
    @Override
    public Staff findOne(Integer id) {
        return staffRepository.getById(id);
    }
 
    @Override
    public Staff insert(Staff staff) {
        return staffRepository.save(staff);
    }
 
    @Override
    public void remove(Integer id) {
        staffRepository.deleteById(id);
    }
 
    @Override
    public void deleteAll() {
        staffRepository.deleteAll();
    }
}

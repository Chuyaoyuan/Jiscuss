package com.yaoyuan.jiscuss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yaoyuan.jiscuss.entity.Staff;
import com.yaoyuan.jiscuss.exception.Error;
import com.yaoyuan.jiscuss.exception.StaffNotFoundException;
import com.yaoyuan.jiscuss.service.IStaffService;
 
@RestController
@RequestMapping(path="/staffRest",produces="application/json;charset=utf-8")
public class RestServiceController {
    @Autowired
    private IStaffService staffService;
 
    @ExceptionHandler(StaffNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error staffNotFound(StaffNotFoundException e){
        Integer id=e.getStaffId();
        return new Error(4,"Staff ["+id+"] not found");
    }
 
    @GetMapping("/{id}")
    public Staff staffById(@PathVariable Integer id){
        Staff staff=staffService.findOne(id);
        if(staff==null){
            throw new StaffNotFoundException(id);
        }
        return staff;
    }
 
    @GetMapping
    public List<Staff> getAllStaffs(){
        return staffService.getAllList();
    }
 
    @PostMapping
    public Staff createStaff(Staff staff){
        return staffService.insert(staff);
    }
 
    @PutMapping
    public Staff updateStaff(Staff staff){
        return staffService.insert(staff);
    }
 
    @DeleteMapping("/{id}")
    public Staff deleteStaffById(@PathVariable Integer id){
        Staff staff=staffService.findOne(id);
        if(staff==null){
            throw new StaffNotFoundException(id);
        }
        staffService.remove(id);
        return staff;
    }
 
    @DeleteMapping
    public List<Staff> deleteAllStaffs(){
        List<Staff> staffList=staffService.getAllList();
        staffService.deleteAll();
        return staffList;
    }
}

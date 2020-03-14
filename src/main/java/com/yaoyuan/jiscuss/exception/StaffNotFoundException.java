package com.yaoyuan.jiscuss.exception;

@SuppressWarnings("serial")
public class StaffNotFoundException extends RuntimeException {
    private Integer staffId;
    public StaffNotFoundException(Integer staffId){
        this.staffId=staffId;
    }
    public Integer getStaffId(){
        return staffId;
    }
}

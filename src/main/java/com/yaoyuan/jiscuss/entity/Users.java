package com.yaoyuan.jiscuss.entity;


import java.io.Serializable;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Entity
@Table(name="users")
public class Users   implements Serializable {
    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
 
    @Column(name="username")
    private String username;
    
    @Column(name="realname")
    private String realname;
    
    @Column(name="email")
    private String email;
    
    @Column(name="password")
    private String password;
    
    @Column(name="join_time")
    private Date join_time;
 
    @Column(name="age")
    private Integer age;
    
    @Column(name="gender")
    private String gender;
    
    @Column(name="phone")
    private String phone;
    
    @Column(name="discussions_count")
    private Integer discussions_count;
    
    @Column(name="comments_count")
    private Integer comments_count;
    
    @Column(name="last_seen_time")
    private Date last_seen_time;
 
    @Column(name="flag")
    private Integer flag;
    
    @Column(name="level")
    private Integer level;

}
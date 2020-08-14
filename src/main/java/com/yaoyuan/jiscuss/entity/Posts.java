package com.yaoyuan.jiscuss.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="posts")
public class Posts   implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="discussion_id")
    private Integer discussion_id;
    
    @Column(name="number")
    private Integer number;
    
    @Column(name="time")
    private Date time;
    
    @Column(name="user_id")
    private Integer user_id;
    
    @Column(name="type")
    private String type;
    
    @Column(name="content")
    private String content;

    @Column(name="parent_id")
    private Integer parent_id;
    
    @Column(name="edit_time")
    private Date edit_time;
    
    @Column(name="edit_user_id")
    private Integer edit_user_id;
    
    @Column(name="ip_address")
    private String ip_address;
    
    @Column(name="copyright")
    private String copyright;
    
    @Column(name="is_approved")
    private Integer is_approved;
    
    @Column(name="create_id")
    private Integer create_id;
    
    @Column(name="create_time")
    private Date create_time;
}


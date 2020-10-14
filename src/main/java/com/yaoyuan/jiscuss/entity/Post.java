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
@Table(name="post")
public class Post implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="discussion_id")
    private Integer discussionId;
    
    @Column(name="number")
    private Integer number;
    
    @Column(name="time")
    private Date time;
    
    @Column(name="user_id")
    private Integer userId;
    
    @Column(name="type")
    private String type;
    
    @Column(name="content")
    private String content;

    @Column(name="parent_id")
    private Integer parentId;
    
    @Column(name="edit_time")
    private Date editTime;
    
    @Column(name="edit_user_id")
    private Integer editUserId;
    
    @Column(name="ip_address")
    private String ipAddress;
    
    @Column(name="copyright")
    private String copyright;
    
    @Column(name="is_approved")
    private Integer isApproved;
    
    @Column(name="create_id")
    private Integer createId;
    
    @Column(name="create_time")
    private Date createTime;
}


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
@Table(name="discussions")
public class Discussions   implements Serializable {
	  private static final long serialVersionUID = 1L;
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id", unique = true)
	    private Integer id;
	    
	    @Column(name="title")
	    private String title;
	    
	    @Column(name="content")
	    private String content;
	    
	    @Column(name="comments_count")
	    private Integer comments_count;
	    
	    @Column(name="participants_count")
	    private Integer participants_count;
	    
	    @Column(name="number_index")
	    private Integer number_index;
	    
	    @Column(name="start_time")
	    private Date start_time;
	    
	    @Column(name="start_user_id")
	    private Integer start_user_id;
	    
	    @Column(name="start_post_id")
	    private Integer start_post_id;
	    
	    @Column(name="last_time")
	    private Date last_time;
	    
	    @Column(name="last_user_id")
	    private Integer last_user_id;
	    
	    @Column(name="last_post_id")
	    private Integer last_post_id;
	    
	    @Column(name="last_post_number")
	    private Integer last_post_number;
	    
	    @Column(name="is_approved")
	    private Integer is_approved;
	    
	    @Column(name="like_count")
	    private Integer like_count;
	    
	    
	    @Column(name="ip_address")
	    private String ip_address;
	    
	    @Column(name="create_id")
	    private Integer create_id;
	    
	    @Column(name="create_time")
	    private Date create_time;
	      
}

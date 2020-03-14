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
@Table(name="tags")
public class Tags   implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="description")
    private String description;
    
    @Column(name="color")
    private String color;
    
    @Column(name="position")
    private Integer position;
    
    @Column(name="parent_id")
    private Integer parent_id;

    @Column(name="discussions_count")
    private String discussions_count;
    
    @Column(name="last_time")
    private Date last_time;
    
    @Column(name="last_discussion_id")
    private Integer last_discussion_id;
    
    @Column(name="create_id")
    private Integer create_id;
    
    @Column(name="create_time")
    private Date create_time;
}

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
@Table(name = "tag")
public class Tag implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "color")
    private String color;

    @Column(name = "icon")
    private String icon;

    @Column(name = "position")
    private Integer position;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "discussions_count")
    private String discussionsCount;

    @Column(name = "last_time")
    private Date lastTime;

    @Column(name = "last_discussion_id")
    private Integer lastDiscussionId;

    @Column(name = "create_id")
    private Integer createId;

    @Column(name = "create_time")
    private Date createTime;
}

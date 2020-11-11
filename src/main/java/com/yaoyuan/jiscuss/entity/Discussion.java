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
@Table(name = "discussion")
public class Discussion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "comments_count")
    private Integer commentsCount;

    @Column(name = "participants_count")
    private Integer participantsCount;

    @Column(name = "number_index")
    private Integer numberIndex;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "start_user_id")
    private Integer startUserId;

    @Column(name = "start_post_id")
    private Integer startPostId;

    @Column(name = "last_time")
    private Date lastTime;

    @Column(name = "last_user_id")
    private Integer lastUserId;

    @Column(name = "last_post_id")
    private Integer lastPostId;

    @Column(name = "last_post_number")
    private Integer lastPostNumber;

    @Column(name = "is_approved")
    private Integer isApproved;

    @Column(name = "like_count")
    private Integer likeCount;


    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "create_id")
    private Integer createId;

    @Column(name = "create_time")
    private Date createTime;

}

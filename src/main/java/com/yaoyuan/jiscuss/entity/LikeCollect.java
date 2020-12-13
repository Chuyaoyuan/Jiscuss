package com.yaoyuan.jiscuss.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yaoyuan2.chu
 * @Title:
 * @Package com.yaoyuan.jiscuss.entity
 * @Description:
 * @date 2020/10/21 12:00
 */
@Data
@Entity
@Table(name = "likecollect")
public class LikeCollect implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "discussion_id")
    private Integer discussionId;

    @Column(name = "discussion_name")
    private String discussionName;

    @Column(name = "tag_id")
    private Integer tagId;

    @Column(name = "post_id")
    private Integer postId;

    @Column(name = "post_content")
    private String postContent;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "type")
    private String type;

    @Column(name = "like_type")
    private String likeType;

    @Column(name = "collect_type")
    private String collectType;

    @Column(name = "create_id")
    private Integer createId;

    @Column(name = "create_time")
    private Date createTime;

}

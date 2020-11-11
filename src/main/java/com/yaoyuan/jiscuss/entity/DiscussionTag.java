package com.yaoyuan.jiscuss.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "discussiontag")
public class DiscussionTag implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "discussion_id")
    private Integer discussionId;

    @Column(name = "tag_id")
    private Integer tagId;


}

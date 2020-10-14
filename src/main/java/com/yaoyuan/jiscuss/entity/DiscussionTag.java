package com.yaoyuan.jiscuss.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="discussiontag")
public class DiscussionTag implements Serializable{
    private static final long serialVersionUID = 1L;
      
    @Id
    @Column(name="discussion_id")
    private Integer discussionId;
     
    @Column(name="tag_id")
    private Integer tagId;
    
   
}

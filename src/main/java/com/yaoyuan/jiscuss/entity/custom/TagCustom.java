package com.yaoyuan.jiscuss.entity.custom;

import com.yaoyuan.jiscuss.entity.Post;
import com.yaoyuan.jiscuss.entity.Tag;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @author yaoyuan2.chu
 * @Title:
 * @Package com.yaoyuan.jiscuss.entity.custom
 * @Description:
 * @date 2020/10/21 10:05
 */
@Data
@Setter
@Getter
public class TagCustom {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "color")
    private String color;

    @Column(name = "icon")
    private String icon;

    @Column(name = "discussion_id")
    private Integer discussionId;


    public TagCustom(String name, String color, String icon, String description, Integer discussionId) {
        this.name = name;
        this.color = color;
        this.icon = icon;
        this.description = description;
        this.discussionId = discussionId;
    }
}

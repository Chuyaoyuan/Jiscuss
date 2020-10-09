package com.yaoyuan.jiscuss.entity.custom;

import com.yaoyuan.jiscuss.entity.Discussion;
import com.yaoyuan.jiscuss.entity.Tag;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

/**
 * @author yaoyuan2.chu
 * @Title:
 * @Package com.yaoyuan.jiscuss.entity.custom
 * @Description:
 * @date 2020/9/9 14:44
 */

@Data
@Setter
@Getter
public class DiscussionCustom extends Discussion {

    private String avatar;

    private String username;

    private String realname;

    private String avatarLast;

    private String usernameLast;

    private String realnameLast;

    private String tag;

    private List<Tag> tagList;


}

package com.yaoyuan.jiscuss.entity.custom;

import com.yaoyuan.jiscuss.entity.Post;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;

/**
 * @author yaoyuan2.chu
 * @Title:
 * @Package com.yaoyuan.jiscuss.entity.custom
 * @Description:
 * @date 2020/9/9 14:44
 */
@Data
public class PostCustom extends Post {

    private String avatar;

    private String username;

    private String realname;

    private String avatarReply;

    private String usernameReply;

    private String realnameReply;

    private List<PostCustom> child;



}

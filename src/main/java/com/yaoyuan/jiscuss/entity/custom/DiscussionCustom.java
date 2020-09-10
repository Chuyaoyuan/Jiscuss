package com.yaoyuan.jiscuss.entity.custom;

import com.yaoyuan.jiscuss.entity.Discussion;
import lombok.Data;

/**
 * @author yaoyuan2.chu
 * @Title:
 * @Package com.yaoyuan.jiscuss.entity.custom
 * @Description:
 * @date 2020/9/9 14:44
 */

@Data
public class DiscussionCustom extends Discussion {

    private String avatar;

    private String username;

    private String realname;

    private String avatarLast;

    private String usernameLast;

    private String realnameLast;

}

package com.yaoyuan.jiscuss.service;

import com.yaoyuan.jiscuss.entity.Post;
import com.yaoyuan.jiscuss.entity.custom.PostCustom;

import java.util.List;

public interface IPostsService {
    List<Post> getAllList();

    Post insert(Post post);

    List<Post> findOneBy(Integer id);

    List<PostCustom> findPostCustomById(Integer id);

    Post findOneByid(Integer parentId);
}

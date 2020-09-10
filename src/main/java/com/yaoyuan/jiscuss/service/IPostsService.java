package com.yaoyuan.jiscuss.service;

import java.util.List;
import java.util.Map;

import com.yaoyuan.jiscuss.entity.Post;
import com.yaoyuan.jiscuss.entity.custom.PostCustom;

public interface IPostsService {
    List<Post> getAllList();

    Post insert(Post post);

    List<Post> findOneBy(Integer id);

    List<PostCustom> findPostCustomById(Integer id);

    Post findOneByid(Integer parentId);
}

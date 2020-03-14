package com.yaoyuan.jiscuss.service;

import java.util.List;

import com.yaoyuan.jiscuss.entity.Posts;

public interface IPostsService {
    List<Posts> getAllList();

    Posts insert(Posts posts);
}

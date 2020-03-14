package com.yaoyuan.jiscuss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yaoyuan.jiscuss.entity.Posts;
import com.yaoyuan.jiscuss.repository.PostsRepository;
import com.yaoyuan.jiscuss.service.IPostsService;

public class PostsServiceImpl implements IPostsService {
    @Autowired
    private PostsRepository postsRepository;

    @Override
    public List<Posts> getAllList() {
        return postsRepository.findAll();
    }

    @Override
    public Posts insert(Posts posts) {
        return postsRepository.save(posts);
    }
}

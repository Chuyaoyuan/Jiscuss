package com.yaoyuan.jiscuss.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.yaoyuan.jiscuss.entity.Posts;
import com.yaoyuan.jiscuss.repository.PostsRepository;
import com.yaoyuan.jiscuss.service.IPostsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class PostsServiceImpl implements IPostsService {
    @Autowired
    private PostsRepository postsRepository;

    @Override
    public List<Posts> getAllList() {
        return postsRepository.findAll();
    }

    @Override
    public List<Posts> findOneBy(Integer id) {

        List<Posts> posts = postsRepository.findOneBy(id);
        return posts;
    }

    @Override
    public List<Posts> findAllByDIdAndparentIdNull(Integer dId) {
        List<Posts> posts = postsRepository.findAllByDIdAndparentIdNull(dId);
        return posts;
    }

    @Override
    public List<Posts> findAllByDIdAndparentIdNotNull(Integer dId) {
        List<Posts> posts = postsRepository.findAllByDIdAndparentIdNotNull(dId);
        return posts;
    }


    @Override
    public Posts insert(Posts posts) {
        return postsRepository.save(posts);
    }
}

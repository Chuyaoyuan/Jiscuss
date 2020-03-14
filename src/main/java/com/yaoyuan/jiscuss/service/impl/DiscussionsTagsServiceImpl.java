package com.yaoyuan.jiscuss.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaoyuan.jiscuss.entity.DiscussionsTags;
import com.yaoyuan.jiscuss.repository.DiscussionsTagsRepository;
import com.yaoyuan.jiscuss.service.IDiscussionsTagsService;

@Service
@Transactional
public class DiscussionsTagsServiceImpl implements IDiscussionsTagsService {
    @Autowired
    private DiscussionsTagsRepository discussionsTagsRepository;

    @Override
    public List<DiscussionsTags> getAllList() {
        return discussionsTagsRepository.findAll();
    }

    @Override
    public DiscussionsTags insert(DiscussionsTags discussionsTags) {
        return discussionsTagsRepository.save(discussionsTags);
    }


}

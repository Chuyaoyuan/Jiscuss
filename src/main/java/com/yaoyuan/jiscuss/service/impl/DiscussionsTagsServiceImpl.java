package com.yaoyuan.jiscuss.service.impl;

import com.yaoyuan.jiscuss.entity.DiscussionTag;
import com.yaoyuan.jiscuss.repository.DiscussionsTagsRepository;
import com.yaoyuan.jiscuss.service.IDiscussionsTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DiscussionsTagsServiceImpl implements IDiscussionsTagsService {

    @Autowired
    private DiscussionsTagsRepository discussionsTagsRepository;

    @Override
    public List<DiscussionTag> getAllList() {
        return discussionsTagsRepository.findAll();
    }

    @Override
    public DiscussionTag insert(DiscussionTag discussionTag) {
        return discussionsTagsRepository.save(discussionTag);
    }
}

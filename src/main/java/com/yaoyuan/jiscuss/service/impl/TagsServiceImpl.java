package com.yaoyuan.jiscuss.service.impl;

import com.yaoyuan.jiscuss.entity.Tag;
import com.yaoyuan.jiscuss.entity.custom.TagCustom;
import com.yaoyuan.jiscuss.repository.TagsRepository;
import com.yaoyuan.jiscuss.service.ITagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TagsServiceImpl implements ITagsService {
    @Autowired
    private TagsRepository tagsRepository;

    @Override
    public List<Tag> getAllList() {
        return tagsRepository.findAllIsNull();
    }

    @Override
    public List<Tag> getAllListDiscussions() {
        return tagsRepository.findAll();
    }

    @Override
    public Tag insert(Tag tag) {
        return tagsRepository.save(tag);
    }

    @Override
    public List<Tag> findByDId(Integer id) {
        return tagsRepository.findByDId(id);
    }

    @Override
    public List<TagCustom> findByDiscussionIdlistId(List<Integer> discussionIdLsit) {
        return tagsRepository.findByDiscussionIdlistId(discussionIdLsit);
    }

    @Override
    public List<Tag> findByParentId(String tag) {
        int tagId = Integer.parseInt(tag);
        return tagsRepository.findByParentId(tagId);
    }
}



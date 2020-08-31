package com.yaoyuan.jiscuss.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.yaoyuan.jiscuss.entity.Tags;
import com.yaoyuan.jiscuss.repository.TagsRepository;
import com.yaoyuan.jiscuss.service.ITagsService;

@Service
@Transactional
public class TagsServiceImpl implements ITagsService {
    @Autowired
    private TagsRepository tagsRepository;

    @Override
    public List<Tags> getAllList() {
        return tagsRepository.findAll();
    }

    @Override
    public Tags insert(Tags tags) {
        return tagsRepository.save(tags);
    }

    @Override
    public List<Tags> findByDId(Integer id) {
        return tagsRepository.findByDId(id);
    }
}



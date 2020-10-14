package com.yaoyuan.jiscuss.service;

import java.util.List;

import com.yaoyuan.jiscuss.entity.Tag;

public interface ITagsService {

    List<Tag> getAllList();

    Tag insert(Tag tag);

    List<Tag> findByDId(Integer id);
}

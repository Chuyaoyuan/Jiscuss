package com.yaoyuan.jiscuss.service;

import java.util.List;

import com.yaoyuan.jiscuss.entity.Tags;

public interface ITagsService {

    List<Tags> getAllList();

    Tags insert(Tags tags);

    List<Tags> findByDId(Integer id);
}

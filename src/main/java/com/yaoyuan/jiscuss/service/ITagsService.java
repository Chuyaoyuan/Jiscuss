package com.yaoyuan.jiscuss.service;

import java.util.List;

import com.yaoyuan.jiscuss.entity.Tag;
import com.yaoyuan.jiscuss.entity.custom.TagCustom;

public interface ITagsService {

    List<Tag> getAllList();

    Tag insert(Tag tag);

    List<Tag> findByDId(Integer id);

    List<TagCustom> findByDiscussionIdlistId(List<Integer> discussionIdLsit);
}

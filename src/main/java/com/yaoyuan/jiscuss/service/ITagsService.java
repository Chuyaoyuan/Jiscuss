package com.yaoyuan.jiscuss.service;

import com.yaoyuan.jiscuss.entity.Tag;
import com.yaoyuan.jiscuss.entity.custom.TagCustom;

import java.util.List;

public interface ITagsService {

    List<Tag> getAllList();

    Tag insert(Tag tag);

    List<Tag> findByDId(Integer id);

    List<TagCustom> findByDiscussionIdlistId(List<Integer> discussionIdLsit);

    List<Tag> findByParentId(String tag);

    List<Tag> getAllListDiscussions();
}

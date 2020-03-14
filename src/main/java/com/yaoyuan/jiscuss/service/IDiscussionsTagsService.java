package com.yaoyuan.jiscuss.service;

import java.util.List;

import com.yaoyuan.jiscuss.entity.DiscussionsTags;

public interface IDiscussionsTagsService {

    List<DiscussionsTags> getAllList();

    DiscussionsTags insert(DiscussionsTags discussionsTags);
}

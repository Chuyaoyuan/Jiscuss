package com.yaoyuan.jiscuss.service;

import java.util.List;

import com.yaoyuan.jiscuss.entity.DiscussionTag;

public interface IDiscussionsTagsService {

    List<DiscussionTag> getAllList();

    DiscussionTag insert(DiscussionTag discussionTag);
}

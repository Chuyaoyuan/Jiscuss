package com.yaoyuan.jiscuss.service;

import com.yaoyuan.jiscuss.entity.DiscussionTag;

import java.util.List;

public interface IDiscussionsTagsService {

    List<DiscussionTag> getAllList();

    DiscussionTag insert(DiscussionTag discussionTag);
}

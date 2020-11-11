package com.yaoyuan.jiscuss.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.yaoyuan.jiscuss.entity.Discussion;

public interface IDiscussionsService {

    List<Discussion> getAllList();

    Discussion insert(Discussion discussion);

    Discussion findOne(Integer id);

    Page<Discussion> queryAllDiscussionsList(Discussion discussion, int pageNumNew, int pageSiz, String tag, String type);
}

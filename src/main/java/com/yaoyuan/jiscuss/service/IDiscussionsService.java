package com.yaoyuan.jiscuss.service;

import com.yaoyuan.jiscuss.entity.Discussion;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IDiscussionsService {

    List<Discussion> getAllList();

    Discussion insert(Discussion discussion);

    Discussion findOne(Integer id);

    Page<Discussion> queryAllDiscussionsList(Discussion discussion, int pageNumNew, int pageSiz, String tag, String type);
}

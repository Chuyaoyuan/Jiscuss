package com.yaoyuan.jiscuss.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.yaoyuan.jiscuss.entity.Discussions;

public interface IDiscussionsService {

    List<Discussions> getAllList();

    Discussions insert(Discussions discussions);

    Discussions findOne(Integer id);
    
    Page<Discussions> queryAllDiscussionsList(Discussions discussions,int pageNum,int pageSize);

}

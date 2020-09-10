package com.yaoyuan.jiscuss.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.yaoyuan.jiscuss.entity.Discussion;
import com.yaoyuan.jiscuss.repository.DiscussionsRepository;
import com.yaoyuan.jiscuss.service.IDiscussionsService;

@Service
@Transactional
public class DiscussionsServiceImpl implements IDiscussionsService {
    @Autowired
    private DiscussionsRepository discussionsRepository;

    @Override
    public List<Discussion> getAllList() {
        return discussionsRepository.findAll();
    }

    @Override
    public Discussion insert(Discussion discussion) {

        return discussionsRepository.save(discussion);
    }

    @Override
    public Discussion findOne(Integer id) {
        Discussion discussion = new Discussion();
        discussion.setId(id);
        return discussionsRepository.getOne(id);
    }

	@Override
	public Page<Discussion> queryAllDiscussionsList(Discussion discussion, int pageNum, int pageSize) {
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        @SuppressWarnings("deprecation")
		Pageable pageable=new PageRequest(pageNum,pageSize,sort);
        //将匹配对象封装成Example对象
        Example<Discussion> example = Example.of(discussion);

        return  discussionsRepository.findAll(example,pageable);
    }
}

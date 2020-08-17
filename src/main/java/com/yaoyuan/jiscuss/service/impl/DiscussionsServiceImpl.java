package com.yaoyuan.jiscuss.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.yaoyuan.jiscuss.entity.Discussions;
import com.yaoyuan.jiscuss.repository.DiscussionsRepository;
import com.yaoyuan.jiscuss.service.IDiscussionsService;

@Service
@Transactional
public class DiscussionsServiceImpl implements IDiscussionsService {
    @Autowired
    private DiscussionsRepository discussionsRepository;

    @Override
    public List<Discussions> getAllList() {
        return discussionsRepository.findAll();
    }

    @Override
    public Discussions insert(Discussions discussions) {

        return discussionsRepository.save(discussions);
    }

    @Override
    public Discussions findOne(Integer id) {
        Discussions discussions = new Discussions();
        discussions.setId(id);
        return discussionsRepository.getOne(id);
    }

	@Override
	public Page<Discussions> queryAllDiscussionsList(Discussions discussions,int pageNum, int pageSize) {
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        @SuppressWarnings("deprecation")
		Pageable pageable=new PageRequest(pageNum,pageSize,sort);
        //将匹配对象封装成Example对象
        Example<Discussions> example = Example.of(discussions);

        return  discussionsRepository.findAll(example,pageable);
    }
}

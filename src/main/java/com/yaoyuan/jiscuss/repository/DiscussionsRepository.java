package com.yaoyuan.jiscuss.repository;

import com.yaoyuan.jiscuss.entity.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscussionsRepository extends JpaRepository<Discussion,Integer> {

    
}

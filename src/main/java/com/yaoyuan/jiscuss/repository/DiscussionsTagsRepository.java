package com.yaoyuan.jiscuss.repository;

import com.yaoyuan.jiscuss.entity.DiscussionsTags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DiscussionsTagsRepository extends JpaRepository<DiscussionsTags,Integer> {
}

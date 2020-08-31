package com.yaoyuan.jiscuss.repository;

import com.yaoyuan.jiscuss.entity.Posts;
import com.yaoyuan.jiscuss.entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagsRepository extends JpaRepository<Tags,Integer> {

    @Query(value = "FROM Tags a, DiscussionsTags b WHERE a.id = b.tagId and b.discussionId = :dId")
    List<Tags> findByDId(@Param("dId")Integer dId);
}

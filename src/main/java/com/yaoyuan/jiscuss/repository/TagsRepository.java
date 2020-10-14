package com.yaoyuan.jiscuss.repository;

import com.yaoyuan.jiscuss.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagsRepository extends JpaRepository<Tag,Integer> {

    @Query(value = "FROM Tag a, DiscussionTag b WHERE a.id = b.tagId and b.discussionId = :dId")
    List<Tag> findByDId(@Param("dId")Integer dId);
}

package com.yaoyuan.jiscuss.repository;

import com.yaoyuan.jiscuss.entity.Tag;
import com.yaoyuan.jiscuss.entity.custom.TagCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagsRepository extends JpaRepository<Tag, Integer> {

    @Query(value = "FROM Tag a, DiscussionTag b WHERE a.id = b.tagId and b.discussionId = :dId")
    List<Tag> findByDId(@Param("dId") Integer dId);


    @Query("select new com.yaoyuan.jiscuss.entity.custom.TagCustom(" +
            "u.name,u.color,u.icon,u.description, d.discussionId" +
            ") " +
            "from Tag u, DiscussionTag d " +
            "where u.id=d.tagId and d.discussionId in (:discussionIdlist)")
    List<TagCustom> findByDiscussionIdlistId(@Param(value = "discussionIdlist") List<Integer> discussionIdlist);

    List<Tag> findByParentId(Integer tagId);

    @Query(value = "FROM Tag a WHERE a.parentId is null")
    List<Tag> findAllIsNull();
}

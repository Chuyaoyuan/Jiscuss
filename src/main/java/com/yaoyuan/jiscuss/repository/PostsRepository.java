package com.yaoyuan.jiscuss.repository;

import com.yaoyuan.jiscuss.entity.Post;
import com.yaoyuan.jiscuss.entity.custom.PostCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PostsRepository extends JpaRepository<Post, Integer> {

    /**
     * @param dId
     * @return
     */
    @Query("from Post where discussionId = :dId")
    List<Post> findOneBy(@Param("dId") Integer dId);

    @Query(value = "select p.*,u.avatar as user_avatar ,u.username as user_username ,u.realname as user_realname ," +
            "u2.avatar as create_avatar ,u2.username as create_username ,u2.realname as create_realname  \n" +
            "from post p  \n" +
            "left join user u on p.user_id = u.id \n" +
            "left join user u2 on p.create_id = u2.id \n" +
            "where p.discussion_id = :dId order by p.create_time desc"
            , nativeQuery = true)
    List<Map<String, Object>> findPostCustomById(@Param("dId") Integer dId);


    @Query(value = "select p.*,u.avatar as user_avatar ,u.username as user_username ,u.realname as user_realname ," +
            "u2.avatar as create_avatar ,u2.username as create_username ,u2.realname as create_realname  \n" +
            "from post p  \n" +
            "left join user u on p.user_id = u.id \n" +
            "left join user u2 on p.create_id = u2.id \n" +
            "where p.discussion_id = :dId and p.parent_id is null order by p.create_time desc"
            , nativeQuery = true)
    List<Map<String, Object>> findAllByDIdAndparentIdNull(@Param("dId") Integer dId);

    @Query(value = "select p.*,u.avatar as user_avatar ,u.username as user_username ,u.realname as user_realname ," +
            "u2.avatar as create_avatar ,u2.username as create_username ,u2.realname as create_realname  \n" +
            "from post p  \n" +
            "left join user u on p.user_id = u.id \n" +
            "left join user u2 on p.create_id = u2.id \n" +
            "where p.discussion_id = :dId and p.parent_id is not null order by p.create_time desc"
            , nativeQuery = true)
    List<Map<String, Object>> findAllByDIdAndparentIdNotNull(@Param("dId") Integer dId);


//    @Query("from Post where parentId is null and discussionId = :dId")
//    List<Post> findAllByDIdAndparentIdNull(@Param("dId")Integer dId);
//
//    @Query("from Post where parentId is not null and discussionId = :dId")
//    List<Post> findAllByDIdAndparentIdNotNull(@Param("dId")Integer dId);
}

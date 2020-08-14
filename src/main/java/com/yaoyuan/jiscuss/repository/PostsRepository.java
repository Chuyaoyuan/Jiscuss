package com.yaoyuan.jiscuss.repository;

import com.yaoyuan.jiscuss.entity.Posts;
import com.yaoyuan.jiscuss.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts,Integer> {

    /**
     *
     * @param dId
     * @return
     */
    @Query("from Posts where discussion_id = :dId")
    List<Posts> findOneBy(@Param("dId")Integer dId);

}

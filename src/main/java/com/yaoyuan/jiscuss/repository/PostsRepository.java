package com.yaoyuan.jiscuss.repository;

import com.yaoyuan.jiscuss.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Posts,Integer> {
}

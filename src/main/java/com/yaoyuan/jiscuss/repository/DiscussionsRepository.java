package com.yaoyuan.jiscuss.repository;

import com.yaoyuan.jiscuss.entity.Discussion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscussionsRepository extends JpaRepository<Discussion, Integer> {

    @Query(value = "SELECT * from discussion where id in (\n" +
            "SELECT discussion_id from discussiontag where tag_id = ?1 )  ", nativeQuery = true)
    Page<Discussion> findByQuery(String tagId, Pageable pageable);


}

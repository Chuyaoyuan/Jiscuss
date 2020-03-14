package com.yaoyuan.jiscuss.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yaoyuan.jiscuss.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer> {
   @Query("from Staff where name like %:name%")
   List<Staff> getByNameIsLike(@Param("name")String name);

   Staff getById(Integer id);
   void deleteById(Integer id);
}

package com.yaoyuan.jiscuss.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yaoyuan.jiscuss.entity.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {
   /**
    *
    * @param username
    * @return
    */
   @Query("from Users where username like %:username%")
   List<Users> getByUsernameIsLike(@Param("username")String username);

   /**
    *
    * @param id
    * @return
    */
   Users getById(Integer id);

   /**
    *
    * @param username
    * @return
    */
   @Query("from Users where username = :username")
   Users getByUsername(String username);

   /**
    *
    * @param username
    * @param password
    * @return
    */
   @Query("from Users where username = :username and password = :password")
   Users checkByUsernameAndPassword(String username, String password);
   
}

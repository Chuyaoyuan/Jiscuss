package com.yaoyuan.jiscuss.repository;

import com.yaoyuan.jiscuss.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
    /**
     * @param username
     * @return
     */
    @Query("from User where username like %:username%")
    List<User> getByUsernameIsLike(@Param("username") String username);

    /**
     * @param id
     * @return
     */
    User getById(Integer id);

    /**
     * @param username
     * @return
     */
    @Query("from User where username = :username")
    User getByUsername(String username);

    /**
     * @param username
     * @param password
     * @return
     */
    @Query("from User where username = :username and password = :password")
    User checkByUsernameAndPassword(String username, String password);

}

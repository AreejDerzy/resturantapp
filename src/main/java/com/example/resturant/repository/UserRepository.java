package com.example.resturant.repository;

import com.example.resturant.model.loginUser;
import com.example.resturant.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<user, Integer> {

    @Query("SELECT new loginUser(u.userId,u.userName,u.userPassword) from user u where u.userName = :name and u.userPassword = :pass")
    public loginUser findLoginUser(@Param("name") String name,@Param("pass") String pass);


    @Query("SELECT u from user u where u.userName LIKE %?1%")
    public user search(String key);


    @Query("SELECT u from user u where u.userName = :name and u.userEmail = :email")
    public user CheckAccount(@Param("name") String name,@Param("email") String email);

}

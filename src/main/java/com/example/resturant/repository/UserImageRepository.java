package com.example.resturant.repository;

import com.example.resturant.model.userImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserImageRepository extends JpaRepository<userImage, Integer> {

    @Query("SELECT im from userImage im where im.userId = :id")
    public Optional<userImage> findUserId(@Param("id") int id);
}

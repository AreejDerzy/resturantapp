package com.example.resturant.repository;

import com.example.resturant.model.resturant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResturantRepository extends JpaRepository<resturant, Integer> {

    @Query("SELECT r from resturant r where r.resturantName LIKE %?1%")
    public resturant search(String key);
}

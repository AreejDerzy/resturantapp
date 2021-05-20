package com.example.resturant.repository;

import com.example.resturant.model.mealImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MealImageRepository  extends JpaRepository<mealImage, Integer> {

    @Query("SELECT im from mealImage im where im.mealId = :id")
    public Optional<mealImage> findMealId(@Param("id") int id);

}

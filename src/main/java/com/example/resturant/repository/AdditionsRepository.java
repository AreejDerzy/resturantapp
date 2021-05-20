package com.example.resturant.repository;

import com.example.resturant.model.additions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdditionsRepository extends JpaRepository<additions, Integer> {


    @Query("SELECT new additions(a.additionsId,a.additionsName,a.mealId) "+
            "  FROM additions a , meal m where m.mealId=a.mealId and  m.mealId=?1 ")
    public List<additions> AdditionsInfo(int id);

}

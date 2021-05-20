package com.example.resturant.repository;

import com.example.resturant.model.meal;
import com.example.resturant.model.mealCategorie;
import com.example.resturant.model.mealName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<meal, Integer> {

    @Query("SELECT new mealName(m.mealId,m.mealName) FROM mealName m ")
    public List<mealName> findAllMeal();


    @Query("SELECT new mealCategorie(m.mealId,m.mealName,m.description,m.type,m.price,c.categorieId,c.categorieName) "+
            "  FROM meal m , categorie c where c.categorieId=m.categorieId ")
    public List<mealCategorie> getmealInfo();


    @Query("SELECT new mealCategorie(m.mealId,m.mealName,m.description,m.type,m.price,c.categorieId,c.categorieName) "+
            "  FROM meal m , categorie c where c.categorieId=m.categorieId and m.mealName LIKE %?1%")
    public mealCategorie SearchByName(String key);


    @Query("SELECT new mealCategorie(m.mealId,m.mealName,m.description,m.type,m.price,c.categorieId,c.categorieName) " +
            " FROM meal m , categorie c where c.categorieId=m.categorieId and m.type LIKE %?1%")
    public List<mealCategorie> SearchByType(String type);

    //display categorie with meal
    @Query("SELECT new mealCategorie(m.mealId,m.mealName,m.description,m.type,m.price,c.categorieId,c.categorieName) "+
            "  FROM meal m , categorie c where c.categorieId=m.categorieId  and  m.categorieId=?1 ")
    public List<mealCategorie> DisplayCategorie(Integer id);


}

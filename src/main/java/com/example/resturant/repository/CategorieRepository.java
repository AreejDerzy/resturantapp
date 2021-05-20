package com.example.resturant.repository;

import com.example.resturant.model.categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategorieRepository extends JpaRepository<categorie, Integer>  {

    @Query("SELECT c from categorie c where c.categorieName LIKE %?1%")
    public categorie SearchCategorie(String key);

}

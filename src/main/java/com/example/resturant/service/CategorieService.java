package com.example.resturant.service;

import com.example.resturant.model.categorie;
import com.example.resturant.repository.CategorieRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    //all catigories
    public List<categorie> findAllcategoriesService()
    {
        return (List<categorie>) categorieRepository.findAll();
    }

    //find catigorie by id
    public Optional<categorie> findByIdcategorieService(Integer id)
    {
        return categorieRepository.findById(id);
    }

    /////search a categorie
    public categorie getCategorieService(String key) { return categorieRepository.SearchCategorie(key); }

    //add or update catigorie
    public categorie AddOrUpdateCatigorieService(categorie categorieObj)
    {      //add
        if (categorieObj.getcategorieId() == 0) {
            categorieObj = categorieRepository.save(categorieObj);
            return categorieObj;

        } else {
            Optional<categorie> newCategotie = categorieRepository.findById(categorieObj.getcategorieId());
            //update
            if (newCategotie.isPresent()) {
                categorie newEntity = newCategotie.get();
                newEntity.setcategorieName(categorieObj.getcategorieName());
                newEntity = categorieRepository.save(newEntity);
                return newEntity;
            } else {
                categorieObj = categorieRepository.save(categorieObj);
                return categorieObj;
            }
        }

    }

    //delete catigorie
    public void deleteCategorie(int id)
    {
        categorieRepository.deleteById(id);
    }

}

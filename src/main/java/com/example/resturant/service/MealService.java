package com.example.resturant.service;

import com.example.resturant.model.meal;
import com.example.resturant.model.mealCategorie;
import com.example.resturant.repository.MealRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    /////meal information
    public List<mealCategorie> findMealService() {
        return mealRepository.getmealInfo();
    }

    //find meal by id
    public Optional<meal> findByIdMealService(Integer id)
    {
        return mealRepository.findById(id);
    }


    //add or update meal
    public meal AddOrUpdateMealService(meal mealObj)
    {      //add
        if (mealObj.getmealId() == 0) {
            mealObj = mealRepository.save(mealObj);
            return mealObj;

        } else {
            Optional<meal> newMeal = mealRepository.findById(mealObj.getmealId());
            //update
            if (newMeal.isPresent()) {
                meal newEntity = newMeal.get();
                newEntity.setmealName(mealObj.getmealName());
                newEntity.setdescription(mealObj.getdescription());
                newEntity.settype(mealObj.gettype());
                newEntity.setprice(mealObj.getprice());
                newEntity.setcategorieId(mealObj.getcategorieId());
                newEntity = mealRepository.save(newEntity);
                return newEntity;
            } else {
                mealObj = mealRepository.save(mealObj);
                return mealObj;
            }
        }

    }

    //delete meal
    public void deletemeal(Integer id)
    {
        mealRepository.deleteById(id);
    }

    //search a meal by name
    public mealCategorie SearchMealByNameService(String key){

        return mealRepository.SearchByName(key);
    }

    //search a meal by type
    public List<mealCategorie> SearchMealBytypeService(String type)
    {
        return mealRepository.SearchByType(type);
    }

    //display categorie with meal by categorie id
    public List<mealCategorie> DisplayMealInCategorie(Integer id)
    {
        return mealRepository.DisplayCategorie(id);
    }

}

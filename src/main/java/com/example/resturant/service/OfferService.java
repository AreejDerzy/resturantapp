package com.example.resturant.service;

import com.example.resturant.model.*;
import com.example.resturant.repository.MealRepository;
import com.example.resturant.repository.OfferRepository;

import java.util.List;
import java.util.Optional;

import com.example.resturant.repository.ResturantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;
    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private ResturantRepository resturantRepository;


    ///////add or update offer
    public offer AddOrUpdateOfferService(offer offerObj)
    {
        if (offerObj.getofferId() == 0) {
            offerObj = offerRepository.save(offerObj);
            return offerObj;

        } else {
            Optional<offer> newOffer = offerRepository.findById(offerObj.getofferId());

            if (newOffer.isPresent()) {
                offer newEntity = newOffer.get();
                newEntity.setcontent(offerObj.getcontent());
                newEntity.setprice(offerObj.getprice());
                newEntity.setstartDate(offerObj.getstartDate());
                newEntity.setendDate(offerObj.getendDate());
                newEntity.setresturantId(offerObj.getresturantId());
                newEntity.setmealId(offerObj.getmealId());
                newEntity = offerRepository.save(newEntity);
                return newEntity;
            } else {
                offerObj = offerRepository.save(offerObj);
                return offerObj;
            }
        }

    }

    ////////delete offer
    public void deleteOfferService(Integer id)
    {
        offerRepository.deleteById(id);
    }

    /////search a offer
    public offerInfo getOfferService(int key)
    {
        return offerRepository.search(key);
    }

    /////offer information
    public List<offerInfo> findOfferService() {
        return offerRepository.getOffersInfo();
    }

    /////display meal name for dropdown in add offer
    public List<mealName> findAllMealService()
    {
        return (List<mealName>) mealRepository.findAllMeal();
    }

    /////display resturant name for dropdown in add offer
    public List<resturant> findAllResturantService()
    {
        return (List<resturant>) resturantRepository.findAll();
    }



}

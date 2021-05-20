package com.example.resturant.controller;

import com.example.resturant.model.*;

import java.util.List;

import com.example.resturant.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/offer")
public class OfferController {

    @Autowired
    private OfferService offerService;


    @GetMapping("/offerInfo")
    public ResponseModel getOfferInfo() {
        List<offerInfo> newOffer = offerService.findOfferService();

        ResponseModel response = new ResponseModel<>();

        if (newOffer!=null) {
            response.setStatus(true);
            response.setMessage("ok");
            response.setCode(200);
            response.setData(newOffer);
            return response;
        } else {
            response.setStatus(true);
            response.setCode(204);
            response.setMessage("no Content");
            return response;
        }
    }


    @PostMapping("/AddOrUpdateOffer")
    public ResponseModel<offer> AddOrUpdateOffer(@Valid @RequestBody offer of) {
        offer newOffer = offerService.AddOrUpdateOfferService(of);

        ResponseModel response = new ResponseModel<offer>();
        response.setStatus(true);
        response.setMessage("ok");
        response.setCode(200);
        response.setData(newOffer);
        return response;
    }

    @DeleteMapping("/deleteOffer/{id}")
    public ResponseModel deleteOffer(@PathVariable(value = "id") int id) {
        offerService.deleteOfferService(id);
        ResponseModel response = new ResponseModel<>();

        response.setStatus(true);
        response.setMessage("ok");
        response.setCode(200);
        return response;
    }

    @GetMapping("/SearchOffer/{id}")
    public ResponseModel<offerInfo> getOffer(@PathVariable("id") int id)
    {
        offerInfo newOffer = offerService.getOfferService(id);

        ResponseModel response = new ResponseModel<>();
        if (newOffer!=null) {
            response.setStatus(true);
            response.setMessage("ok");
            response.setCode(200);
            response.setData(newOffer);
            return response;
        } else {
            response.setStatus(true);
            response.setCode(204);
            response.setMessage("offer Not found");
            return response;
        }
    }


    @GetMapping("/meals")
    public ResponseModel<mealName> findAllMeals() {
        List<mealName> meals = offerService.findAllMealService();

        ResponseModel response = new ResponseModel<List<meal>>();

        response.setStatus(true);
        response.setMessage("ok");
        response.setCode(200);
        response.setData(meals);
        return response;
    }


    @GetMapping("/resturants")
    public ResponseModel<resturant> findAllResturants() {
        List<resturant> resturants = offerService.findAllResturantService();

        ResponseModel response = new ResponseModel<List<resturant>>();

        response.setStatus(true);
        response.setMessage("ok");
        response.setCode(200);
        response.setData(resturants);
        return response;
    }


}

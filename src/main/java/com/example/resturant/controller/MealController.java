package com.example.resturant.controller;

import com.example.resturant.model.*;

import java.util.List;
import javax.validation.Valid;

import com.example.resturant.service.MealService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.example.resturant.service.MealFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/meal")
public class MealController {

    @Autowired
    private MealService mealservice;

    private final MealFileService fileService;

    public MealController(MealFileService fileService) {
        this.fileService = fileService;
    }


    @GetMapping("/mealInfo")
    public ResponseModel getMealInfo() {
        List<mealCategorie> newMeal = mealservice.findMealService();

        ResponseModel response = new ResponseModel<>();

        if (newMeal!=null) {
            response.setStatus(true);
            response.setMessage("ok");
            response.setCode(200);
            response.setData(newMeal);
            return response;
        } else {
            response.setStatus(true);
            response.setCode(204);
            response.setMessage("no Content");
            return response;
        }
    }

    @PostMapping("/AddOrUpdateMeal")
    public ResponseModel<meal> AddOrUpdateMeal(@Valid @RequestBody meal m) {
        meal newMeal = mealservice.AddOrUpdateMealService(m);

        ResponseModel response = new ResponseModel<meal>();
        response.setStatus(true);
        response.setMessage("ok");
        response.setCode(200);
        response.setData(newMeal);
        return response;
    }


    @DeleteMapping("/deleteMeal/{id}")
    public ResponseModel deleteMeal(@PathVariable(value = "id") int id) {
        mealservice.deletemeal(id);
        ResponseModel response = new ResponseModel<>();

        response.setStatus(true);
        response.setMessage("ok");
        response.setCode(200);
        return response;

    }

    @GetMapping("/SearchMealName/{name}")
    public ResponseModel SearchMealByName(@PathVariable("name") String name){
        mealCategorie newMeal = mealservice.SearchMealByNameService(name);

        ResponseModel response = new ResponseModel<>();
        if (newMeal!=null) {
            response.setStatus(true);
            response.setMessage("ok");
            response.setCode(200);
            response.setData(newMeal);
            return response;
        } else {
            response.setStatus(true);
            response.setCode(204);
            response.setMessage("MealName Not Found ");
            return response;
        }
    }


    @GetMapping("/SearchMealType/{type}")
    public ResponseModel SearchMealByType(@PathVariable("type") String type){
        List<mealCategorie> newMeal = mealservice.SearchMealBytypeService(type);

        ResponseModel response = new ResponseModel<>();
        if (newMeal!=null) {
            response.setStatus(true);
            response.setMessage("ok");
            response.setCode(200);
            response.setData(newMeal);
            return response;
        } else {
            response.setStatus(true);
            response.setCode(204);
            response.setMessage("MealType Not Found ");
            return response;
        }
    }


    @GetMapping("/MealsInCategorie/{id}")
    public Object getMealInCategoie(@PathVariable("id") Integer id){
        List<mealCategorie> meals=null;
        try{
            meals= mealservice.DisplayMealInCategorie(id);
            ResponseModel response = new ResponseModel<resturant>();
            response.setStatus(true);
            response.setMessage("ok");
            response.setCode(200);
            response.setData(meals);
            return response;

        }catch (Exception e){
            e.printStackTrace();
        }
        return meals;
    }


    //image
    @PutMapping("/uploadMealImage/{id}")
    public ResponseModel uploadMealImage(@RequestParam("file") MultipartFile file,@PathVariable ("id")int id) {
        try {
            fileService.save(file,id);

            ResponseModel response = new ResponseModel<>();
            response.setStatus(true);
            response.setMessage("ok");
            response.setCode(200);
            response.setData("Uploaded the image successfully: " + file.getOriginalFilename());
            return response;

        } catch (Exception e) {
            ResponseModel response = new ResponseModel<>();
            response.setStatus(true);
            response.setCode(204);
            response.setMessage("the image is exist before ReChoose the image: " + file.getOriginalFilename());
            return response;
        }
    }


    @GetMapping("/loadMealImage/{id}")
    @ResponseBody
    public ResponseEntity<Resource> loadMealImage(@PathVariable int id) {
        Resource file = fileService.load(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);

    }

}

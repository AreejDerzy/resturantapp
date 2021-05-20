package com.example.resturant.controller;

import com.example.resturant.model.ResponseModel;
import com.example.resturant.model.additions;
import java.util.List;
import com.example.resturant.service.AdditionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/additions")
public class AdditionsController {

    @Autowired
    private AdditionsService additionsService;

//    @GetMapping("/addition")
//    public ResponseModel<additions> findAllAdditions() {
//        List<additions> additions = additionsService.findAllAdditionsService();
//
//        ResponseModel response = new ResponseModel<List<additions>>();
//
//        response.setStatus(true);
//        response.setMessage("ok");
//        response.setCode(200);
//        response.setData(additions);
//        return response;
//    }

//    @GetMapping("/{id}")
//    public ResponseModel<additions> findAdditionsById(@PathVariable(value = "id") int id) {
//        Optional<additions> additions = additionsService.findByIdAdditionsService(id);
//
//        ResponseModel response = new ResponseModel<additions>();
//
//        if (additions.isPresent()) {
//            response.setStatus(true);
//            response.setMessage("ok");
//            response.setCode(200);
//            response.setData(additions.get());
//            return response;
//        } else {
//            response.setStatus(true);
//            response.setCode(204);
//            response.setMessage("no Content");
//            return response;
//        }
//
//    }


    @GetMapping("/AdditionsInfo/{id}")
    public ResponseModel getAdditionByMealId(@PathVariable(value = "id") int id){

        List<additions> newAddition = additionsService.getAdditionsService(id);

        ResponseModel response = new ResponseModel<>();

        if (newAddition!=null) {
            response.setStatus(true);
            response.setMessage("ok");
            response.setCode(200);
            response.setData(newAddition);
            return response;
        } else {
            response.setStatus(true);
            response.setCode(204);
            response.setMessage("no Content");
            return response;
        }
    }

    @PostMapping("/AddOrUpdateAddition")
    public ResponseModel<additions> AddOrUpdateReaturant(@Valid @RequestBody additions f) {
        additions newAdditions = additionsService.AddOrUpdateAdditionsService(f);

        ResponseModel response = new ResponseModel<additions>();
        response.setStatus(true);
        response.setMessage("ok");
        response.setCode(200);
        response.setData(newAdditions);
        return response;
    }


    @DeleteMapping("/deleteAdditions/{id}")
    public ResponseModel deleteAdditions(@PathVariable(value = "id") int id) {
        additionsService.deleteAdditions(id);
        ResponseModel response = new ResponseModel<>();

        response.setStatus(true);
        response.setMessage("ok");
        response.setCode(200);
        return response;
    }

}

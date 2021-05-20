package com.example.resturant.controller;

import com.example.resturant.model.ResponseModel;
import com.example.resturant.model.resturant;
import java.util.List;
import java.util.Optional;

import com.example.resturant.service.ResturantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/resturant")
public class ResturantController {

    @Autowired
    private ResturantService resturantService;

    @GetMapping("/resturants")
    public ResponseModel<resturant> findAllResturants() {
        List<resturant> resturants = resturantService.findAllResturantsService();

        ResponseModel response = new ResponseModel<List<resturant>>();

        response.setStatus(true);
        response.setMessage("ok");
        response.setCode(200);
        response.setData(resturants);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseModel<resturant> findResturantById(@PathVariable(value = "id") int id) {
        Optional<resturant> resturant = resturantService.findByIdResturantService(id);

        ResponseModel response = new ResponseModel<resturant>();

        if (resturant.isPresent()) {
            response.setStatus(true);
            response.setMessage("ok");
            response.setCode(200);
            response.setData(resturant.get());
            return response;
        } else {
            response.setStatus(true);
            response.setCode(204);
            response.setMessage("no Content");
            return response;
        }

    }
    @PostMapping("/AddOrUpdateResturant")
    public ResponseModel<resturant> AddOrUpdateResturant( @Valid @RequestBody resturant f) {
        resturant newResturant = resturantService.AddOrUpdateResturantService(f);

        ResponseModel response = new ResponseModel<resturant>();
        response.setStatus(true);
        response.setMessage("ok");
        response.setCode(200);
        response.setData(newResturant);
        return response;
    }


    @DeleteMapping("/deleteResturant/{id}")
    public ResponseModel deleteResturant(@PathVariable(value = "id") int id) {
        resturantService.deleteResturant(id);
        ResponseModel response = new ResponseModel<>();

        response.setStatus(true);
        response.setMessage("ok");
        response.setCode(200);
        return response;
    }

    @GetMapping("/SearchResturant/{name}")
    public ResponseModel<resturant> getResturant(@PathVariable("name") String name)
    {
        resturant newResturant =resturantService.getResturantService(name);

        ResponseModel response = new ResponseModel<>();
        if (newResturant!=null) {
            response.setStatus(true);
            response.setMessage("ok");
            response.setCode(200);
            response.setData(newResturant);
            return response;
        } else {
            response.setStatus(true);
            response.setCode(204);
            response.setMessage("Resturant Not Found ");
            return response;
        }
    }

}

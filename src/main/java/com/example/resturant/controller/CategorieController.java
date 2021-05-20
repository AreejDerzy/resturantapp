package com.example.resturant.controller;

import com.example.resturant.model.ResponseModel;
import com.example.resturant.model.categorie;

import java.util.List;
import java.util.Optional;

import com.example.resturant.service.CategorieService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categorie")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/categories")
    public ResponseModel<categorie> findAllcategoris() {
        List<categorie> Categorie = categorieService.findAllcategoriesService();

        ResponseModel response = new ResponseModel<List<categorie>>();

        response.setStatus(true);
        response.setMessage("ok");
        response.setCode(200);
        response.setData(Categorie);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseModel<categorie> findcategorieById(@PathVariable(value = "id") int id) {
        Optional<categorie> Categorie = categorieService.findByIdcategorieService(id);

        ResponseModel response = new ResponseModel<categorie>();

        if (Categorie.isPresent()) {
            response.setStatus(true);
            response.setMessage("ok");
            response.setCode(200);
            response.setData(Categorie.get());
            return response;
        } else {
            response.setStatus(true);
            response.setCode(204);
            response.setMessage("no Content");
            return response;
        }

    }
    @PostMapping("/AddOrUpdateCategorie")
    public ResponseModel<categorie> AddOrUpdateCategorie (@Valid @RequestBody categorie f) {
        categorie Categorie = categorieService.AddOrUpdateCatigorieService(f);

        ResponseModel response = new ResponseModel<categorie>();
        response.setStatus(true);
        response.setMessage("ok");
        response.setCode(200);
        response.setData(Categorie);
        return response;
    }


    @DeleteMapping("/deleteCategorie/{id}")
    public ResponseModel deleteCategorie(@PathVariable(value = "id") int id) {

        categorieService.deleteCategorie(id);

        ResponseModel response = new ResponseModel<categorie>();

        response.setStatus(true);
        response.setMessage("ok");
        response.setCode(200);
        return response;
    }

    @GetMapping("/SearchCategorie/{name}")
    public ResponseModel<categorie> getCategorie(@PathVariable("name") String name)
    {
        categorie newCategorie =categorieService.getCategorieService(name);

        ResponseModel response = new ResponseModel<>();
        if (newCategorie!=null) {
            response.setStatus(true);
            response.setMessage("ok");
            response.setCode(200);
            response.setData(newCategorie);
            return response;
        } else {
            response.setStatus(true);
            response.setCode(204);
            response.setMessage("Categorie Not Found ");
            return response;
        }
    }

}

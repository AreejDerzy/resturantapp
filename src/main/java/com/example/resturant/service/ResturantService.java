package com.example.resturant.service;

import com.example.resturant.model.resturant;
import com.example.resturant.model.user;
import com.example.resturant.repository.ResturantRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service
public class ResturantService {

    @Autowired
    private ResturantRepository resturantrepository;

    //all resturants
    public List<resturant> findAllResturantsService()
    {
        return (List<resturant>) resturantrepository.findAll();
    }

    //find resturant by id
    public Optional<resturant> findByIdResturantService(Integer id)
    {
        return resturantrepository.findById(id);
    }

    /////search a resturant
    public resturant getResturantService(String key) { return resturantrepository.search(key); }


    //add or update resturant
    public resturant AddOrUpdateResturantService(resturant resturantObj)
    {      //add
        if (resturantObj.getresturantId() == 0) {
            resturantObj = resturantrepository.save(resturantObj);
            return resturantObj;

        } else {
            Optional<resturant> newResturant = resturantrepository.findById(resturantObj.getresturantId());
            //update
            if (newResturant.isPresent()) {
                resturant newEntity = newResturant.get();
                newEntity.setresturantName(resturantObj.getresturantName());
                newEntity.setlocation(resturantObj.getlocation());
                newEntity = resturantrepository.save(newEntity);
                return newEntity;
            } else {
                resturantObj = resturantrepository.save(resturantObj);
                return resturantObj;
            }
        }

    }

    //delete resturant
    public void deleteResturant(int id)
    {
        resturantrepository.deleteById(id);
    }

    //validation
//    @Override
//    public void validate(Object obj,Errors error)
//    {
//        resturant resturantObj=(resturant)obj;
//        if(resturantObj.equals(obj)){
//            ValidationUtils.rejectIfEmpty(error,"resturant.resturantName" ,"");
//            if(resturantObj.getresturantName()==null){
//                ValidationUtils.rejectIfEmpty(error,"resturant.resturantName","","Please choose different resturant name");
//            }
//            else
//            {
//                try{
//                    throw new Exception("Object of referance variable obj not equal referance variable resturantobj");
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        }
//
//    }
//
//    @SuppressWarnings("rawtypes")
//    @Override
//    public boolean supports(Class clazz) {
//        return resturant.class.isAssignableFrom(clazz);
//    }

}

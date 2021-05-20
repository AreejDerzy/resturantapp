package com.example.resturant.service;

import com.example.resturant.model.additions;
import com.example.resturant.repository.AdditionsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdditionsService {

    @Autowired
    private AdditionsRepository additionsrepository;

    //all additions
//    public List<additions> findAllAdditionsService()
//    {
//        return (List<additions>) additionsrepository.findAll();
//    }

    //find additions by id
//    public Optional<additions> findByIdAdditionsService(Integer id)
//    {
//        return additionsrepository.findById(id);
//    }


    //display addition information
    public List<additions> getAdditionsService(int id)
    {
        return additionsrepository.AdditionsInfo(id);
    }

    //add or update additions
    public additions AddOrUpdateAdditionsService(additions additionsObj)
    {      //add
        if (additionsObj.getadditionsId() == 0) {
            additionsObj = additionsrepository.save(additionsObj);
            return additionsObj;

        } else {
            Optional<additions> newAdditions = additionsrepository.findById(additionsObj.getadditionsId());
            //update
            if (newAdditions.isPresent()) {
                additions newEntity = newAdditions.get();
                newEntity.setadditionsName(additionsObj.getadditionsName());
                newEntity.setmealId(additionsObj.getmealId());
                newEntity = additionsrepository.save(newEntity);
                return newEntity;
            } else {
                additionsObj = additionsrepository.save(additionsObj);
                return additionsObj;
            }
        }

    }

    //delete additions
    public void deleteAdditions(Integer id)
    {
        additionsrepository.deleteById(id);
    }

}

package com.example.resturant.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.example.resturant.model.mealImage;
import com.example.resturant.repository.MealImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MealFileService {


    @Value("${upload.path}")
    private String uploadPath;
    @Autowired
    private MealImageRepository mealImageRepository;

    @PostConstruct
    public void init() {
        try {
            Files.createDirectories(Paths.get(uploadPath));
        } catch (IOException e) {
            throw new RuntimeException("Could not create upload folder!");
        }
    }

    public void save(MultipartFile file,int id) {
        try {
            Path root = Paths.get(uploadPath);
            //update image meal
            Optional<mealImage> newMealImage = mealImageRepository.findMealId(id);
            if (newMealImage.isPresent())
            {
                mealImage newEntity = newMealImage.get();

                newEntity.setimageName(file.getOriginalFilename());
                newEntity.setimageurl(uploadPath + "/" + file.getOriginalFilename());
                newEntity.setimageSize((int) file.getSize());
                mealImageRepository.save(newEntity);

                //add image meal
            } else {
                mealImage addImage = new mealImage();

                addImage.setmealId(id);
                addImage.setimageName(file.getOriginalFilename());
                addImage.setimageurl(uploadPath+"/"+file.getOriginalFilename());
                addImage.setimageSize((int) Files.size(root));
                mealImageRepository.save(addImage);
            }
            //////////////////////////////////////////////

            if (!Files.exists(root)) {
                init();
            }
            Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    public Resource load(int id ) {
        try {

            Optional<mealImage> newImage = mealImageRepository.findMealId(id);
            Path file = Paths.get(uploadPath).resolve(newImage.get().getimageName());
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

}

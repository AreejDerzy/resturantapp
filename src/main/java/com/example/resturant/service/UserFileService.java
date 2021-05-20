package com.example.resturant.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.example.resturant.model.userImage;
import com.example.resturant.repository.UserImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserFileService {

    @Value("${upload.path}")
    private String uploadPath;
    @Autowired
    private UserImageRepository userImageRepository;

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
            //update image user
            Optional<userImage> newUserImage = userImageRepository.findUserId(id);
            if (newUserImage.isPresent())
            {
                userImage newEntity = newUserImage.get();

                newEntity.setimageName(file.getOriginalFilename());
                newEntity.setimageurl(uploadPath + "/" + file.getOriginalFilename());
                newEntity.setimageSize((int) file.getSize());
                userImageRepository.save(newEntity);

             //add image user
            } else {
                    userImage addImage = new userImage();

                    addImage.setuserId(id);
                    addImage.setimageName(file.getOriginalFilename());
                    addImage.setimageurl(uploadPath+"/"+file.getOriginalFilename());
                    addImage.setimageSize((int) Files.size(root));
                    userImageRepository.save(addImage);
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

            Optional<userImage> newUser = userImageRepository.findUserId(id);
            Path file = Paths.get(uploadPath).resolve(newUser.get().getimageName());
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

//    public void deleteAll() {
//        FileSystemUtils.deleteRecursively(Paths.get(uploadPath)
//                .toFile());
//    }

//    public List<Path> loadAll() {
//        try {
//
//            Path root = Paths.get(uploadPath);
//            if (Files.exists(root)) {
//                return Files.walk(root, 1)
//                        .filter(path -> !path.equals(root))
//                        .collect(Collectors.toList());
//            }
//
//            return Collections.emptyList();
//        } catch (IOException e) {
//            throw new RuntimeException("Could not list the files!");
//        }
//    }

//    public user pathToFileData(Path path) {
//        user fileData = new user();
//        String filename = path.getFileName().toString();
//        fileData.setimageName(filename);
//        fileData.setimageurl(MvcUriComponentsBuilder.fromMethodName(UserController.class, "getFile", filename)
//                .build()
//                .toString());
//        try {
//            fileData.setimageSize((int) Files.size(path));
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Error: " + e.getMessage());
//        }
//
//        return fileData;
//    }

}


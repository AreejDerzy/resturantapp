package com.example.resturant.controller;

import com.example.resturant.model.*;

import java.util.List;
import java.util.Optional;

import com.example.resturant.service.UserFileService;
import com.example.resturant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    private final UserFileService fileService;

    public UserController(UserFileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/users")
    public ResponseModel<user> findAllUsers() {
        List<user> users = userService.findAllUsersService();

        ResponseModel response = new ResponseModel<List<user>>();
        response.setStatus(true);
        response.setMessage("ok");
        response.setCode(200);
        response.setData(users);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseModel<user> findUserById(@PathVariable(value = "id") int id) {
        Optional<user> u = userService.findByIdUserService(id);

        ResponseModel response = new ResponseModel<user>(); //constuructor for a single user response

        if (u.isPresent()) {
            //  return ResponseEntity.ok().body(user.get());
            response.setStatus(true);
            response.setMessage("ok");
            response.setCode(200);
            response.setData(u.get());
            return response;
        } else {
            // return ResponseEntity.notFound().build();
            response.setStatus(true);
            response.setCode(204);
            response.setMessage("no Content");
            return response;
        }
    }

    @PostMapping("/AddOrUpdateUser")
    public ResponseModel<user> AddOrUpdateUser(@Valid @RequestBody user u) {

        user userAccount=userService.CheckUserAccountService(u.getuserName(),u.getuserEmail());

        ResponseModel response = new ResponseModel<user>();

        if(userAccount!=null)
        {
            response.setStatus(true);
            response.setCode(204);
            response.setMessage("UserName Or Email exist before ReEnter Information");
            return response;
        }

        else {
            user newUser = userService.AddOrUpdateUserService(u);

            response.setStatus(true);
            response.setMessage("ok");
            response.setCode(200);
            response.setData(newUser);
            return response;
        }
    }


//    @DeleteMapping("/deleteUser/{id}")
//    public ResponseModel deleteUser(@PathVariable(value = "id") int id) {
//        userService.deleteUserService(id);
//
//        ResponseModel response = new ResponseModel<>();
//        response.setStatus(true);
//        response.setMessage("ok");
//        response.setCode(200);
//        return response;
//    }

    @PostMapping("/LoginUser")
    public ResponseModel<user> LoginUser(@Valid @RequestBody loginUser u)
    {
        loginUser newUserLogin =userService.findLoginUserService(u.getuserName(),u.getuserPassword());

        ResponseModel response = new ResponseModel<>();
        if(newUserLogin!=null)
        {
           Optional<user> newUser =userService.findByIdUserService(newUserLogin.getuserId());
            response.setStatus(true);
            response.setMessage("ok");
            response.setCode(200);
            response.setData(newUser);
            return response;
        }
        else {
            response.setStatus(true);
            response.setCode(204);
            response.setMessage("User Not Register");
            return response;
        }
    }


    @GetMapping("/SearchUser/{name}")
    public ResponseModel<user> getUser(@PathVariable("name") String name)
    {
        user newUser =userService.getUserService(name);

        ResponseModel response = new ResponseModel<>();
        if (newUser!=null) {
            response.setStatus(true);
            response.setMessage("ok");
            response.setCode(200);
            response.setData(newUser);
            return response;
        } else {
            response.setStatus(true);
            response.setCode(204);
            response.setMessage("User Not Found ");
            return response;
        }
    }


    @GetMapping("/role/{id}")
    public ResponseModel<role> getRoleUser(@PathVariable(value = "id") int id) {
        Optional<role> getRole = userService.getRoleUserService(id);

        ResponseModel response = new ResponseModel<role>();
        response.setStatus(true);
        response.setMessage("ok");
        response.setCode(200);
        response.setData(getRole);
        return response;
    }

    @PostMapping("/status")
    public ResponseModel<user> changeStatusUser(@RequestBody user u) {
        user s = userService.changeStatusUserService(u.getuserStatus(), u.getuserId());

        ResponseModel response = new ResponseModel<user>();
        response.setStatus(true);
        response.setMessage("ok");
        response.setCode(200);
        response.setData(s);
        return response;
    }

    /////////////////////////////////////////////////////
    //manager
    @GetMapping("/manager/{id}")
    public ResponseModel<manager> findManagerById(@PathVariable(value = "id") int id) {
        Optional<manager> m = userService.getInfoManagerService(id);

        ResponseModel response = new ResponseModel<manager>();

        if (m.isPresent()) {
            response.setStatus(true);
            response.setMessage("ok");
            response.setCode(200);
            response.setData(m.get());
            return response;
        } else {
            response.setStatus(true);
            response.setCode(204);
            response.setMessage("no Content");
            return response;
        }
    }

    @PostMapping("/AddOrUpdateManager")
    public ResponseModel<manager> AddOrUpdateManager(@Valid @RequestBody manager m) {
        manager newManager = userService.AddOrUpdateManagerService(m);

        ResponseModel response = new ResponseModel<manager>();
        response.setStatus(true);
        response.setMessage("ok");
        response.setCode(200);
        response.setData(newManager);
        return response;
    }

   
    //////////////////////////////////////////////////////
    //image
    @PutMapping("/uploadUserImage/{id}")
    public ResponseModel uploadUserImage(@RequestParam("file") MultipartFile file,@PathVariable ("id")int id) {
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


  @GetMapping("/loadUserImage/{id}")
    @ResponseBody
    public ResponseEntity<Resource> loadUserImage(@PathVariable int id) {
        Resource file = fileService.load(id);

      return ResponseEntity.ok()
              .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
              .body(file);

    }

}
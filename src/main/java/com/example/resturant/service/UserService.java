package com.example.resturant.service;

import com.example.resturant.model.*;
import com.example.resturant.repository.ManagerRepository;
import com.example.resturant.repository.RoleRepository;
import com.example.resturant.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ManagerRepository managerRepository;


    /////all users
    public List<user> findAllUsersService() {
        return (List<user>) userRepository.findAll();
    }

    ////////find user by id
    public Optional<user> findByIdUserService(int id) {
        // return repository.findById(id).get(); return user
        return userRepository.findById(id);
    }


    ///////add or update user
    public user AddOrUpdateUserService(user userObj) {
        if (userObj.getuserId() == 0) {
            userObj.setuserStatus("Active");
            userObj.setuserDate(LocalDate.now());
            userObj = userRepository.save(userObj);
            return userObj;

        } else {
            Optional<user> newUser = userRepository.findById(userObj.getuserId());

            if (newUser.isPresent()) {
                user newEntity = newUser.get();
                newEntity.setuserName(userObj.getuserName());
                newEntity.setuserPassword(userObj.getuserPassword());
                newEntity.setuserConfirmedPassword(userObj.getuserConfirmedPassword());
                newEntity.setuserEmail(userObj.getuserEmail());
                newEntity.setroleId(userObj.getroleId());
                newEntity = userRepository.save(newEntity);
                return newEntity;
            } else {
                userObj = userRepository.save(userObj);
                return userObj;
            }
        }

    }

    ////////delete user
//    public void deleteUserService(Integer id) {
//        userRepository.deleteById(id);
//    }

    /////login a user
    public loginUser findLoginUserService(String name,String pass) {
            return userRepository.findLoginUser(name,pass);
    }

    /////check a user account
    public user CheckUserAccountService(String name,String email) {
        return userRepository.CheckAccount(name,email);
    }


    /////search a user
    public user getUserService(String key) {
            return userRepository.search(key);
    }

    ////////get role for user
    public Optional<role> getRoleUserService(Integer roleId) {
        return roleRepository.findById(roleId);
    }

    ////////status user
    public user changeStatusUserService(String status, int id) {
        Optional<user> newUser = userRepository.findById(id);

        user newEntity = newUser.get();
        newEntity.setuserStatus(status);
        return userRepository.save(newEntity);
    }

    //////////////////////////////////////////////////////
    //manager
    ////////find manager by id
    public Optional<manager> getInfoManagerService(Integer id) {
        return managerRepository.findById(id);
    }

    ///////add or update manager
    public manager AddOrUpdateManagerService(manager managerObj) {
        if (managerObj.getmanagerId() == 0) {
            managerObj = managerRepository.save(managerObj);
            return managerObj;

        } else {
            Optional<manager> newManager = managerRepository.findById(managerObj.getmanagerId());

            if (newManager.isPresent()) {
                manager newEntity = newManager.get();
                newEntity.setfirstName(managerObj.getfirstName());
                newEntity.setlastName(managerObj.getlastName());
                newEntity.setmanagerAge(managerObj.getmanagerAge());
                newEntity.setuserId(managerObj.getuserId());
                newEntity.setresturantId(managerObj.getresturantId());
                newEntity = managerRepository.save(newEntity);
                return newEntity;
            } else {
                managerObj = managerRepository.save(managerObj);
                return managerObj;
            }
        }
    }

    //////////////////////////////////////////////////////



}

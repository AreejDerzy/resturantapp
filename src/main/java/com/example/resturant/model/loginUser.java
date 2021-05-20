package com.example.resturant.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
@Table(name="user")
public class loginUser implements Serializable {
    public loginUser() { }
    public loginUser(int id,String name,String password)
    {
        this.userId=id;
        this.userName=name;
        this.userPassword=password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    public int getuserId() { return userId; }

    public void setuserId(int userId) { this.userId = userId; }
    ////////////////////////////////////////////
    @NotEmpty(message = "Please provide a name")
    @Column(name = "user_name")
    private String userName;

    public String getuserName() { return userName; }

    public void setuserName(String userName) { this.userName  = userName; }
    ////////////////////////////////////////////
    @NotEmpty(message = "Please provide a password")
    @Column(name = "user_password")
    private String userPassword;

    public String getuserPassword() { return userPassword; }

    public void setuserPassword(String userPassword) { this.userPassword = userPassword; }
    ////////////////////////////////////////////
}

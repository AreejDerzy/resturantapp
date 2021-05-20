package com.example.resturant.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name="user")
public class user implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    public int getuserId() { return userId; }

    public void setuserId(int userId) { this.userId = userId; }
    ////////////////////////////////////////////
    @NotEmpty(message = "Please provide a name")
    @Size(min = 3, message = "userName should have atleast 3 characters")
    @Column(name = "user_name")
    private String userName;

    public String getuserName() { return userName; }

    public void setuserName(String userName) { this.userName  = userName; }
    ////////////////////////////////////////////
    @NotEmpty(message = "Please provide a password")
    @Size(min=7,message="password should have atleast 7 characters")
    @Column(name = "user_password")
    private String userPassword;

    public String getuserPassword() { return userPassword; }

    public void setuserPassword(String userPassword) { this.userPassword = userPassword; }
    ////////////////////////////////////////////
    @NotEmpty(message = "Please provide a ConfirmedPassword")
    private String userConfirmedPassword;

    public String getuserConfirmedPassword() { return userConfirmedPassword; }

    public void setuserConfirmedPassword(String userConfirmedPassword) { this.userConfirmedPassword = userConfirmedPassword; }
    ////////////////////////////////////////////
    @NotEmpty(message = "Please provide a email")
    @Email(message = "Please enter a valid e-mail address")
    @Column(name = "user_email")
    private String userEmail;

    public String getuserEmail() { return userEmail; }

    public void setuserEmail(String userEmail) { this.userEmail = userEmail; }
    ////////////////////////////////////////////

    @Column(name = "user_date")
    private LocalDate userDate;

    public LocalDate getuserDate() { return userDate; }

    public void setuserDate(LocalDate userDate) { this.userDate = userDate; }
    ////////////////////////////////////////////

    @Column(name = "user_status")
    private String userStatus;

    public String getuserStatus() { return userStatus; }

    public void setuserStatus(String userStatus) { this.userStatus  = userStatus; }
    ////////////////////////////////////////////

    @Column(name = "role_id")
    private int roleId;

    public int getroleId() { return roleId; }

    public void setroleId(int roleId) { this.roleId = roleId; }
    ////////////////////////////////////////////

    //check password
    @AssertTrue(message="PasswordConfirmed field should be equal than password field")
    private boolean isValid() {
        return this.userPassword.equals(this.userConfirmedPassword);
    }
}

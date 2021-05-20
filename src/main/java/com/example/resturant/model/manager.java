package com.example.resturant.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="manager")
public class manager implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int managerId;

    public int getmanagerId() {
        return managerId;
    }

    public void setmanagerId(int managerId) {
        this.managerId = managerId;
    }
    ////////////////////////////////////////////
    @NotEmpty(message = "Please provide firstName")
    @Size(min = 3, message = "First Name should have atleast 3 characters")
    @Column(name = "first_name")
    private String firstName ;

    public String getfirstName () {
        return firstName ;
    }

    public void setfirstName (String firstName ) {
        this.firstName  = firstName ;
    }
    ////////////////////////////////////////////
    @NotEmpty(message = "Please provide lastName")
    @Size(min = 3,message = "Last Name should have atleast 2 characters")
    @Column(name = "last_name")
    private String lastName ;

    public String getlastName () {
        return lastName ;
    }

    public void setlastName (String lastName ) {
        this.lastName  = lastName ;
    }
    ////////////////////////////////////////////
    @Min(value = 20, message = "Age should be equal or more than 25")
    @Column(name = "manager_age")
    private int managerAge;

    public int getmanagerAge() {
        return managerAge;
    }

    public void setmanagerAge(int managerAge) {
        this.managerAge = managerAge;
    }
    ////////////////////////////////////////////

    @Column(name = "user_id")
    private int userId ;

    public int getuserId() {
        return userId ;
    }

    public void setuserId(int userId ) {
        this.userId  = userId ;
    }
    ////////////////////////////////////////////

    @Column(name = "resturant_id")
    private int resturantId ;

    public int getresturantId() {
        return resturantId ;
    }

    public void setresturantId(int resturantId ) {
        this.resturantId  = resturantId ;
    }

}

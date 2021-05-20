package com.example.resturant.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="driver")
public class driver implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int driverId;

    public int getdriverId() {
        return driverId;
    }

    public void setdriverId(int driverId) {
        this.driverId = driverId;
    }
    ////////////////////////////////////////////

    @Column(name = "first_name")
    private String firstName ;

    public String getfirstName () {
        return firstName ;
    }

    public void setfirstName (String firstName ) {
        this.firstName  = firstName ;
    }
    ////////////////////////////////////////////

    @Column(name = "last_name")
    private String lastName ;

    public String getlastName () {
        return lastName ;
    }

    public void setlastName (String lastName ) {
        this.lastName  = lastName ;
    }
    ////////////////////////////////////////////

    @Column(name = "driver_age")
    private int driverAge;

    public int getdriverAge() {
        return driverAge;
    }

    public void setdriverAge(int driverAge) {
        this.driverAge = driverAge;
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
}

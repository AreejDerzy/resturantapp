package com.example.resturant.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name="resturant")
public class resturant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int resturantId;

    public int getresturantId() {
        return resturantId;
    }

    public void setresturantId(int resturantId) {
        this.resturantId = resturantId;
    }
    ////////////////////////////////////////////
    @NotEmpty(message="Name may not be empty")
    @Column(name = "resturant_name")
    private String resturantName;

    public String getresturantName() { return resturantName; }

    public void setresturantName(String resturantName) { this.resturantName  = resturantName; }
    ////////////////////////////////////////////
    @NotEmpty(message="location may not be empty")
    @Column(name = "location")
    private String location;

    public String getlocation() { return location; }

    public void setlocation(String location) { this.location = location; }
    ////////////////////////////////////////////

}

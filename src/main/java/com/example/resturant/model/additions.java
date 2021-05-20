package com.example.resturant.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name="additions")
public class additions implements Serializable {

    public additions(){}

    public additions(int additionsId , String additionsName,int mealId) {

        this.additionsId =additionsId;
        this.additionsName = additionsName;
        this.mealId = mealId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int additionsId;

    public int getadditionsId() {
        return additionsId;
    }

    public void setadditionsId(int additionsId) {
        this.additionsId = additionsId;
    }
    ////////////////////////////////////////////
    @NotEmpty(message="Name may not be empty")
    @Column(name = "additions_name")
    private String additionsName;

    public String getadditionsName() {
        return additionsName;
    }

    public void setadditionsName(String additionsName) {
        this.additionsName = additionsName;
    }
    ////////////////////////////////////////////

    @Column(name = "meal_id")
    private int mealId;

    public int getmealId() {
        return mealId;
    }

    public void setmealId(int mealId) {
        this.mealId = mealId;
    }
    ////////////////////////////////////////////
}
package com.example.resturant.model;

import javax.persistence.*;

@Entity
@Table(name="meal")
public class mealName {

    public mealName(){}

    public mealName(int mealId , String mealName) {

        this.mealId = mealId;
        this.mealName = mealName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int mealId;

    public int getmealId() { return mealId; }

    public void setmealId(int mealId) {
        this.mealId = mealId;
    }
    ////////////////////////////////////////////
//    @NotEmpty(message="Name may not be empty")
    @Column(name = "meal_name")
    private String mealName ;

    public String getmealName() {
        return mealName ;
    }

    public void setmealName(String mealName ) {
        this.mealName  = mealName ;
    }
    ////////////////////////////////////////////
}

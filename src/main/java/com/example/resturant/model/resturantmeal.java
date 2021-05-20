package com.example.resturant.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="resturantmeal")
public class resturantmeal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int resturantmealId;

    public int getresturantmealId() {
        return resturantmealId;
    }

    public void setresturantmealId(int resturantmealId) {
        this.resturantmealId = resturantmealId;
    }
    ////////////////////////////////////////////

    @Column(name = "meal_id")
    private int mealId;

    public int getmealId() { return mealId; }

    public void setmealId(int mealId) { this.mealId = mealId; }
    /////////////////////////////////////////////

    @Column(name = "resturant_id")
    private int resturantId;

    public int getresturantId() { return resturantId; }

    public void setresturantId(int resturantId) { this.resturantId = resturantId; }
}

package com.example.resturant.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ordermeal")
public class ordermeal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ordermealId;

    public int getordermealId() {
        return ordermealId;
    }

    public void setordermealId(int ordermealId) {
        this.ordermealId = ordermealId;
    }
    ////////////////////////////////////////////

    @Column(name = "meals_number")
    private int mealsNumber ;

    public int getmealsNumber() {
        return mealsNumber ;
    }

    public void setmealsNumber(int mealsNumber ) {
        this.mealsNumber  = mealsNumber ;
    }
    ////////////////////////////////////////////

    @Column(name = "prepare_time")
    private int prepareTime ;

    public int getprepareTime() {
        return prepareTime ;
    }

    public void setprepareTime(int prepareTime ) {
        this.prepareTime  = prepareTime ;
    }
    ////////////////////////////////////////////

    @Column(name = "meal_id")
    private int mealId ;

    public int getmealId() {
        return mealId ;
    }

    public void setmealId(int mealId ) {
        this.mealId  = mealId ;
    }
    ////////////////////////////////////////////

    @Column(name = "cooker_id")
    private int cookerId ;

    public int getcookerId() {
        return cookerId ;
    }

    public void setcookerId(int cookerId ) {
        this.cookerId  = cookerId ;
    }
    ////////////////////////////////////////////

    @Column(name = "order_id")
    private int orderId ;

    public int getorderId() {
        return orderId ;
    }

    public void setorderId(int orderId ) {
        this.orderId  = orderId ;
    }
    ////////////////////////////////////////////

    @Column(name = "status_type_id")
    private int statusTypeId ;

    public int getstatusTypeId() {
        return statusTypeId ;
    }

    public void setstatusTypeId(int statusTypeId ) {
        this.statusTypeId  = statusTypeId ;
    }
}

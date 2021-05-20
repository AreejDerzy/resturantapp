package com.example.resturant.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="meal")
public class mealNamePrice implements Serializable{
    public mealNamePrice() { }

    public mealNamePrice(int id,String name,int price,int mealsNum) {
        this.mealId = id;
        this.mealName=name;
        this.price=price;
        this.mealsNum=mealsNum;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int mealId;

    public int getmealId() { return mealId; }

    public void setmealId(int mealId) {
        this.mealId = mealId;
    }
    ////////////////////////////////////////////

    @Column(name = "meal_name")
    private String mealName ;

    public String getmealName() {
        return mealName ;
    }

    public void setmealName(String mealName ) {
        this.mealName  = mealName ;
    }
    ////////////////////////////////////////////

    @Column(name = "price")
    private int price ;

    public int getprice () {
        return price ;
    }

    public void setprice (int price ) {
        this.price  = price ;
    }
    ////////////////////////////////////////////

    private int mealsNum ;

    public int getmealsNum() {
        return mealsNum ;
    }

    public void setmealsNum (int mealsNum ) {
        this.mealsNum  = mealsNum ;
    }
    ////////////////////////////////////////////
}

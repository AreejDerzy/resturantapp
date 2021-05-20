package com.example.resturant.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="meal")
public class mealCategorie {

    public mealCategorie(){}

    public mealCategorie(int mealId , String mealName,String description,String type ,int Price,int categorieId,String categorieName) {

        this.mealId = mealId;
        this.mealName = mealName;
        this.description = description;
        this.type = type;
        this.price=Price;
        this.categorieId=categorieId;
        this.categorieName = categorieName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int mealId;

    public int getmealId() { return mealId; }

    public void setmealId(int mealId) {
        this.mealId = mealId;
    }
    ////////////////////////////////////////////
    @NotEmpty(message="Name may not be empty")
    @Column(name = "meal_name", nullable = true)
    private String mealName ;

    public String getmealName() {
        return mealName ;
    }

    public void setmealName(String mealName ) {
        this.mealName  = mealName ;
    }
    ////////////////////////////////////////////
    @NotEmpty(message="description may not be empty")
    @Column(name = "description")
    private String description  ;

    public String getdescription () {
        return description  ;
    }

    public void setdescription  (String description  ) {
        this.description   = description  ;
    }
    ////////////////////////////////////////////
    @NotEmpty(message="type may not be empty")
    @Column(name = "type")
    private String type ;

    public String gettype () {
        return type ;
    }

    public void settype (String type ) {
        this.type  = type ;
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

    @Column(name = "categorie_id")
    private int categorieId ;

    public int getcategorieId() {
        return categorieId ;
    }

    public void setcategorieId(int categorieId ) {
        this.categorieId  = categorieId ;
    }
    ////////////////////////////////////////////

    private String categorieName;

    public String getcategorieName() { return categorieName; }

    public void setcategorieName(String categorieName) { this.categorieName = categorieName; }

}

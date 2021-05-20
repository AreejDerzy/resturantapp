package com.example.resturant.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="offer")
public class offer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int offerId;

    public int getofferId() {
        return offerId;
    }

    public void setofferId(int offerId) {
        this.offerId = offerId;
    }
    ////////////////////////////////////////////
    @NotEmpty(message = "Please provide a content")
    @Size(min = 3, message = "content should have atleast 3 characters")
    @Column(name = "content")
    private String content;

    public String getcontent() {
        return content;
    }

    public void setcontent(String content) {
        this.content = content;
    }
    ////////////////////////////////////////////
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "start_date")
    private Date startDate;

    public Date getstartDate() {
        return startDate;
    }

    public void setstartDate(Date startDate) {
        this.startDate  = startDate;
    }
    ////////////////////////////////////////////
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "end_date")
    private Date endDate;

    public Date getendDate() {
        return endDate;
    }

    public void setendDate(Date endDate) {
        this.endDate  = endDate;
    }
    ////////////////////////////////////////////
    @Min(value = 500, message = "price should be equal or more than 500")
    @Column(name = "price")
    private int price;

    public int getprice() { return price; }

    public void setprice(int price) {
        this.price  = price;
    }
    ////////////////////////////////////////////

    @Column(name = "resturant_id")
    private int resturantId;

    public int getresturantId() {
        return resturantId;
    }

    public void setresturantId(int resturantId) {
        this.resturantId= resturantId;
    }
    ////////////////////////////////////////////

    @Column(name = "meal_id")
    private int mealId;

    public int getmealId() { return mealId; }

    public void setmealId(int mealId) { this.mealId= mealId; }
    ////////////////////////////////////////////

}

package com.example.resturant.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="offer")
public class offerInfo implements Serializable {

    public offerInfo() { }
    public offerInfo(int id,String content,Date start,Date end,int price,String restName,String mealName,int restId,int mealId)
    {
        this.offerId=id;
        this.content=content;
        this.startDate=start;
        this.endDate=end;
        this.price=price;
        this.resturantName=restName;
        this.mealName=mealName;
        this.resturantId=restId;
        this.mealId=mealId;
    }

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

    @Column(name = "price")
    private double price;

    public double getprice() { return price; }

    public void setprice(double price) {
        this.price  = price;
    }
    ////////////////////////////////////////////

    @Column(name = "resturant_id")
    private int resturantId;

    public int getresturantId() { return resturantId; }

    public void setresturantId(int resturantId) { this.resturantId= resturantId; }
    ////////////////////////////////////////////

    @Column(name = "meal_id")
    private int mealId;

    public int getmealId() { return mealId; }

    public void setmealId(int mealId) { this.mealId= mealId; }
    ////////////////////////////////////////////

    private String resturantName;

    public String getresturantName() {
        return resturantName;
    }

    public void setresturantName(String resturantName) {
        this.resturantName  = resturantName;
    }
    ////////////////////////////////////////////

    private String mealName;

    public String getmealName() {
        return mealName;
    }

    public void setmealName(String mealName) {
        this.mealName  = mealName;
    }

}

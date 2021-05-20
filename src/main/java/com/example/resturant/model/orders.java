package com.example.resturant.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="orders")
public class orders  implements Serializable {
    public orders() { }
    public orders(int id,int price,String delivery,Date date,int clientId,int driverId,int restId, int reservationId,
       String restName,String clientName,String driverfName,String driverlName)
    {
        this.orderId=id;
        this.totalPrice=price;
        this.delivery=delivery;
        this.orderDate=date;
        this.clientId=clientId;
        this.driverId=driverId;
        this.resturantId=restId;
        this.reservationId=reservationId;
        this.resturantName=restName;
        this.clientName=clientName;
        this.driverfName=driverfName;
        this.driverlName=driverlName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    public int getorderId() {
        return orderId;
    }

    public void setorderId(int orderId) {
        this.orderId = orderId;
    }
    ////////////////////////////////////////////

    @Column(name = "total_price")
    private int totalPrice;

    public int gettotalPrice() {
        return totalPrice;
    }

    public void settotalPrice(int totalPrice) {
        this.totalPrice  = totalPrice;
    }
    ////////////////////////////////////////////

    @Column(name = "delivery")
    private String delivery;

    public String getdelivery() {
        return delivery;
    }

    public void setdelivery(String delivery) {
        this.delivery  = delivery;
    }
    ////////////////////////////////////////////
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "order_date")
    private Date orderDate;

    public Date getorderDate() {
        return orderDate;
    }

    public void setorderDate(Date orderDate) { this.orderDate  = orderDate; }
    ////////////////////////////////////////////

    @Column(name = "client_id")
    private int clientId;

    public int getclientId() {
        return clientId;
    }

    public void setclientId(int clientId) {
        this.clientId  = clientId;
    }
    ////////////////////////////////////////////

    @Column(name = "driver_id")
    private int driverId;

    public int getdriverId() {
        return driverId;
    }

    public void setdriverId(int driverId) {
        this.driverId  = driverId;
    }
    ////////////////////////////////////////////

    @Column(name = "resturant_id")
    private int resturantId;

    public int getresturantId() {
        return resturantId;
    }

    public void setresturantId(int resturantId) {
        this.resturantId  = resturantId;
    }
    ////////////////////////////////////////////

    @Column(name = "reservation_id")
    private int reservationId;

    public int getreservationId() {
        return reservationId;
    }

    public void setreservationId(int reservationId) {
        this.reservationId  = reservationId;
    }
    ////////////////////////////////////////////

    private String clientName;

    public String getclientName() {
        return clientName;
    }

    public void setclientName(String clientName) {
        this.clientName  = clientName;
    }
    ////////////////////////////////////////////

    private String driverfName;

    public String getdriverfName() {
        return driverfName;
    }

    public void setdriverfName(String driverfName) {
        this.driverfName  = driverfName;
    }
    ////////////////////////////////////////////

    private String driverlName;

    public String getdriverlName() { return driverlName; }

    public void setdriverlName(String driverlName) {
        this.driverlName  = driverlName;
    }
    ////////////////////////////////////////////

    private String resturantName;

    public String getresturantName() {
        return resturantName;
    }

    public void setresturantName(String resturantName) {
        this.resturantName  = resturantName;
    }
    ////////////////////////////////////////////
}

package com.example.resturant.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="orderdriver")
public class orderdriver implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderdriverId;

    public int getorderdriverId() {
        return orderdriverId;
    }

    public void setorderdriverId(int orderdriverId) {
        this.orderdriverId = orderdriverId;
    }
    ////////////////////////////////////////////

    @Column(name = "delivery_time")
    private int deliveryTime ;

    public int getdeliveryTime() {
        return deliveryTime ;
    }

    public void setdeliveryTime(int deliveryTime ) {
        this.deliveryTime  = deliveryTime ;
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

    @Column(name = "driver_id")
    private int driverId ;

    public int getdriverId() {
        return driverId ;
    }

    public void setdriverId(int driverId ) {
        this.driverId  = driverId ;
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

package com.example.resturant.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="reservation")
public class reservation implements Serializable {

    public reservation() { }
    public reservation(int id,String name,int tablenum,Date date,String status,int groupnum,String restName,int restId)
    {
        this.reservationId=id;
        this.reservationName=name;
        this.tableNumber=tablenum;
        this.reservationDate=date;
        this.reservationStatus=status;
        this.groupNumber=groupnum;
        this.resturantName=restName;
        this.resturantId=restId;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reservationId;

    public int getreservationId() {
        return reservationId;
    }

    public void setreservationId(int reservationId) {
        this.reservationId = reservationId;
    }
    ////////////////////////////////////////////

    @Column(name = "reservation_name")
    private String reservationName;

    public String getreservationName() { return reservationName; }

    public void setreservationName(String reservationName) { this.reservationName  = reservationName; }
    ////////////////////////////////////////////

    @Column(name = "group_number")
    private int groupNumber;

    public int getgroupNumber() { return groupNumber; }

    public void setgroupNumber(int groupNumber) { this.groupNumber = groupNumber; }
    ////////////////////////////////////////////

    @Column(name = "reservation_date")
    private Date reservationDate;

    public Date getreservationDate() { return reservationDate; }

    public void setreservationDate(Date reservationDate) { this.reservationDate = reservationDate; }
    ////////////////////////////////////////////

    @Column(name = "reservation_status")
    private String reservationStatus;

    public String getreservationStatus() { return reservationStatus; }

    public void setreservationStatus(String reservationStatus) { this.reservationStatus  = reservationStatus; }
    ////////////////////////////////////////////

    @Column(name = "table_number")
    private int tableNumber ;

    public int gettableNumber() { return tableNumber; }

    public void settableNumber(int tableNumber) { this.tableNumber = tableNumber; }
    ////////////////////////////////////////////

    @Column(name = "resturant_id")
    private int resturantId ;

    public int getresturantId() { return resturantId; }

    public void setresturantId(int resturantId) { this.resturantId = resturantId; }
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

package com.example.resturant.repository;

import com.example.resturant.model.mealNamePrice;
import com.example.resturant.model.orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<orders, Integer> {

    @Query("SELECT new mealNamePrice(m.mealId,m.mealName,m.price,OM.mealsNumber)" +
            " FROM meal m,ordermeal OM,orders ord WHERE ord.orderId=OM.orderId and OM.mealId=m.mealId and ord.orderId =?1")
    public List<mealNamePrice> getOrderDetails(int id);



    @Query("SELECT new orders(ord.orderId,ord.totalPrice,ord.delivery,ord.orderDate,c.clientId,d.driverId,r.resturantId," +
            "re.reservationId,r.resturantName,c.clientName,d.firstName,d.lastName) " +
            "  FROM orders ord , resturant r ,client c ,driver d ,reservation re" +
            " where r.resturantId=ord.resturantId and c.clientId=ord.clientId " +
            " and d.driverId=ord.driverId and re.reservationId=ord.reservationId")
    public List<orders> getOrdersInfo();


    @Query("SELECT new orders(ord.orderId,ord.totalPrice,ord.delivery,ord.orderDate,c.clientId,d.driverId,r.resturantId" +
            ",re.reservationId,r.resturantName,c.clientName,d.firstName,d.lastName) " +
            "  FROM orders ord , resturant r,client c ,driver d ,reservation re" +
            " where r.resturantId=ord.resturantId and ord.orderId=?1 " +
            " and c.clientId=ord.clientId and d.driverId=ord.driverId and re.reservationId=ord.reservationId ")
    public List<orders> search(int key);


}

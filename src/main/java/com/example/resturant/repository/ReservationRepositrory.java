package com.example.resturant.repository;

import com.example.resturant.model.reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepositrory extends JpaRepository<reservation, Integer> {

    @Query("SELECT new reservation (re.reservationId,re.reservationName,re.tableNumber,re.reservationDate,re.reservationStatus,re.groupNumber,r.resturantName,r.resturantId) " +
            "  FROM reservation re , resturant r where re.resturantId=r.resturantId")
    public List<reservation> getReservationsInfo();

    @Query("SELECT new reservation (re.reservationId,re.reservationName,re.tableNumber,re.reservationDate,re.reservationStatus,re.groupNumber,r.resturantName,r.resturantId)" +
            "FROM reservation re , resturant r where re.resturantId=r.resturantId and re.reservationName LIKE %?1%")
    public reservation search(String key);
}

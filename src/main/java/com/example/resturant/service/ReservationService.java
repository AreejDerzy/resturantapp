package com.example.resturant.service;

import com.example.resturant.model.*;

import java.util.ArrayList;
import java.util.List;

import com.example.resturant.repository.ReservationRepositrory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepositrory reservationRepository;


    /////reservation information
    public List<reservation> findReservationService() {
        return reservationRepository.getReservationsInfo();
    }

    /////search a reservation
    public reservation getReservationService(String key) {
            return reservationRepository.search(key);
    }

}

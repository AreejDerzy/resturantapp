package com.example.resturant.controller;

import com.example.resturant.model.*;

import java.util.List;

import com.example.resturant.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;


    @GetMapping("/reservationInfo")
    public ResponseModel getReservationInfo() {
        List<reservation> newReservation = reservationService.findReservationService();

        ResponseModel response = new ResponseModel<>();

        if (newReservation!=null) {
            response.setStatus(true);
            response.setMessage("ok");
            response.setCode(200);
            response.setData(newReservation);
            return response;
        } else {
            response.setStatus(true);
            response.setCode(204);
            response.setMessage("no Content");
            return response;
        }
    }

    @GetMapping("/SearchReservation/{name}")
    public ResponseModel<reservation> getReservation(@PathVariable("name") String name)
    {
        reservation newReservation = reservationService.getReservationService(name);

        ResponseModel response = new ResponseModel<>();
        if (newReservation!=null) {
            response.setStatus(true);
            response.setMessage("ok");
            response.setCode(200);
            response.setData(newReservation);
            return response;
        } else {
            response.setStatus(true);
            response.setCode(204);
            response.setMessage("reservation Not Found");
            return response;
        }
    }


}


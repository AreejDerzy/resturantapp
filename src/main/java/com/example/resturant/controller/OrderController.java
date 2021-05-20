package com.example.resturant.controller;

import com.example.resturant.model.*;

import java.util.List;

import com.example.resturant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/orderInfo")
    public ResponseModel getOrderInfo() {
        List<orders> newOrder = orderService.findOrderService();

        ResponseModel response = new ResponseModel<>();

        if (newOrder!=null) {
            response.setStatus(true);
            response.setMessage("ok");
            response.setCode(200);
            response.setData(newOrder);
            return response;
        } else {
            response.setStatus(true);
            response.setCode(204);
            response.setMessage("no Content");
            return response;
        }
    }


    @GetMapping("/orderDetails/{id}")
    public ResponseModel<mealNamePrice> getOrderDetails(@PathVariable(value = "id") int id) {
        List<mealNamePrice> me = orderService.findOrderDetailsService(id);

        ResponseModel response = new ResponseModel<>();

        if (me!=null) {
            response.setStatus(true);
            response.setMessage("ok");
            response.setCode(200);
            response.setData(me);
            return response;
        } else {
            response.setStatus(true);
            response.setCode(204);
            response.setMessage("no Content");
            return response;
        }
    }


    @GetMapping("/SearchOrder/{id}")
    public ResponseModel<orders> getOrder(@PathVariable("id") int id)
    {
        List<orders> newOrder = orderService.getOrderService(id);

        ResponseModel response = new ResponseModel<>();
        if (newOrder!=null) {
            response.setStatus(true);
            response.setMessage("ok");
            response.setCode(200);
            response.setData(newOrder);
            return response;
        } else {
            response.setStatus(true);
            response.setCode(204);
            response.setMessage("order Not Found");
            return response;
        }
    }

}

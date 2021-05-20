package com.example.resturant.service;

import com.example.resturant.model.*;

import java.util.ArrayList;
import java.util.List;

import com.example.resturant.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    ////order details
    public List<mealNamePrice> findOrderDetailsService(int id) {
        return orderRepository.getOrderDetails(id);
    }

    /////order information
    public List<orders> findOrderService() {
        return orderRepository.getOrdersInfo();
    }

    /////search a order
    public List<orders> getOrderService(int key) {
        return orderRepository.search(key);
    }
}

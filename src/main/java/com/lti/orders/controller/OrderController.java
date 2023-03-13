package com.lti.orders.controller;

import com.lti.orders.model.Order;
import com.lti.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    OrderService service;

    @PostMapping(value={"/order"})
    public int placeOrder(@RequestBody Order o){
        return service.placeOrder(o);
    }

    @PutMapping(value={"/status"})
    public boolean updateOrderStatus(@RequestBody Order o){
        return service.updateOrder(o);
    }


    @GetMapping(value={"/count/{id}"})
    public long totalProductOrders(@PathVariable int id){
        return service.totalProductOrders(id);
    }

    @GetMapping(value={"/order/{id}"})
    public Order getOrderById(@PathVariable int id){
        return service.getOrder(id);
    }
}

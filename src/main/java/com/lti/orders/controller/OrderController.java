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
    @GetMapping(value={"/test"})
    public String getFactories(){
        System.out.println("******Hello World********");
        return "Test order places";
    }

    @PostMapping(value={"/order"})
    public int placeOrder(@RequestBody Order o){
        return service.placeOrder(o);
    }

    @GetMapping(value={"/count/{id}"})
    public long totalProductOrders(@PathVariable int id){
        return service.totalProductOrders(id);
    }
}

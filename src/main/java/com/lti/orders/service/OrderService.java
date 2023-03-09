package com.lti.orders.service;

import com.lti.orders.model.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    int placeOrder(Order o);
    long totalProductOrders(int productId);
}

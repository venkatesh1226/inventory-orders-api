package com.lti.orders.service;

import com.lti.orders.model.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    // connection-string of azure
    final String connectStr ="DefaultEndpointsProtocol=https;AccountName=assessmentstorageacc;AccountKey=awLKVstSRBLmnpPQlSOHGU9dhohqS92GAq7VDNEbRhfR+pUhZGSXFzPSGqO1NMxBTY2zZDpkBp1Q+AStsueaJQ==;EndpointSuffix=core.windows.net";
    int placeOrder(Order o);
    long totalProductOrders(int productId);
    boolean updateOrder(Order o);
    public void insertIntoQueue(Order o);
    Order getOrder(int id);
}

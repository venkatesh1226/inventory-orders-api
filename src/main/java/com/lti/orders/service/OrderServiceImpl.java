package com.lti.orders.service;

import com.lti.orders.model.Order;
import com.lti.orders.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepo repo;
    @Override
    public int placeOrder(Order o) {
        return repo.save(o).getOrderId();
    }

    @Override
    public long totalProductOrders(int productId) {

        long count = 0;
        for(Order o:repo.findAll()){
            if(productId==o.getpId())
                count++;
        }
        return count;
    }


}

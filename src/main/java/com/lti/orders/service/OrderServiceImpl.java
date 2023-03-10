package com.lti.orders.service;

import com.google.gson.Gson;
import com.lti.orders.model.Order;
import com.lti.orders.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// Include the following imports to use queue APIs
import com.azure.core.util.*;
import com.azure.storage.queue.*;
import com.azure.storage.queue.models.*;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepo repo;
    @Override
    public int placeOrder(Order o) {
       Order saved= repo.save(o);
        insertIntoQueue(saved);
        return saved.getOrderId();
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

    @Override
    public boolean updateOrder(Order o) {
        repo.save(new Order(o.getOrderId(),o.getpId(),o.getCount(),o.getTime(),o.getStatus()));
        return false;
    }

    @Override
    public void insertIntoQueue(Order o){
        try {
            QueueClient queueClient = new QueueClientBuilder()
                    .connectionString(connectStr)
                    .queueName("venkatesh-orders-queue")
                    .buildClient();
            //converting to json using gson
            queueClient.sendMessage(new Gson().toJson(o).toString());
        }
        catch (QueueStorageException e){
            System.out.println(e.getMessage());
        }
    }


}

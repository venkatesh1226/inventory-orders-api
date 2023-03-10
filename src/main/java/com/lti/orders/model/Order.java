package com.lti.orders.model;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;


@Entity
@Table(name = "venkatesh_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private int pId;
    private int count;
    private long time;
    private String status;


    public Order(int orderId, int pId, int count, long time, String status) {
        this.orderId = orderId;
        this.pId = pId;
        this.count = count;
        this.time = time;
        this.status = status;
    }

    Order(){

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", pId=" + pId +
                ", count=" + count +
                ", time=" + time +
                '}';
    }
}

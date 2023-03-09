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

    public Order(int orderId, int pId, int fId, int count, long time) {
        this.orderId = orderId;
        this.pId = pId;
        this.count = count;
        this.time = time;
    }


    Order(){

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

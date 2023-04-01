package com.example.demo.components;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

//using mongoDB
@Document
public class Order implements Serializable {
    @Id
    private String orderId;
    private String orderDate;
    private String status;
    private String customerName;
    private String productName;

    public Order() {
    }

    public Order(String orderDate, String status, String customerName, String productName) {
        this.orderDate = orderDate;
        this.status = status;
        this.customerName = customerName;
        this.productName = productName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}

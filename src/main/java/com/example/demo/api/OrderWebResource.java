package com.example.demo.api;

import com.example.demo.components.Order;
import com.example.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

/**
 * Web resource to manage the orders.
 */
@RestController
@RequestMapping(path = "api/v1/orders")
@CrossOrigin
public class OrderWebResource implements Serializable {
    private OrderService orderService;

    @Autowired
    OrderWebResource(OrderService productService) {
        this.orderService = productService;
    }
    @GetMapping
    @Cacheable("orders")
    public List<Order> getOrders() {
        return orderService.getOrders();
    }
}

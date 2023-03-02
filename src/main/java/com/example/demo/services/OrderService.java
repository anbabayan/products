package com.example.demo.services;

import com.example.demo.components.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service to manage the products.
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderService() {
    }

    /**
     * Getting all the orders.
     */
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    /**
     * Saving the order to database.
     *
     * @param order new order to be saved.
     */
    public void save(Order order) {
        orderRepository.save(order);
    }


    /**
     * Deleting an order.
     *
     * @param orderId of the order to be deleted
     */
    public void deleteOrder(String orderId) {
        orderRepository.deleteById(orderId);
    }
}

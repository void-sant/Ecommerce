package com.sk.example.ecommerce.Ecommerce.service;

import com.sk.example.ecommerce.Ecommerce.entity.Order;
import com.sk.example.ecommerce.Ecommerce.entity.OrderItem;
import com.sk.example.ecommerce.Ecommerce.entity.User;
import com.sk.example.ecommerce.Ecommerce.repository.OrderRepository;
import com.sk.example.ecommerce.Ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public Order placeOrder(User user, List<OrderItem> orderItems) {
        Order order = new Order();
        order.setUser(user);
        order.setStatus("PLACED");
        order.setOrderItems(orderItems);
        return orderRepository.save(order);
    }

    public List<Order> getOrdersForUser(User user) {
        return orderRepository.findByUser(user);
    }

    public void updateOrderStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.setStatus(status);
        orderRepository.save(order);
    }
}

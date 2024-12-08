package com.sk.example.ecommerce.Ecommerce.controller;

import com.sk.example.ecommerce.Ecommerce.entity.Order;
import com.sk.example.ecommerce.Ecommerce.entity.OrderItem;
import com.sk.example.ecommerce.Ecommerce.entity.User;
import com.sk.example.ecommerce.Ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody List<OrderItem> orderItems) {
        User currentUser = getCurrentUser();
        Order order = orderService.placeOrder(currentUser, orderItems);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @GetMapping
    public List<Order> getUserOrders() {
        User currentUser = getCurrentUser();
        return orderService.getOrdersForUser(currentUser);
    }

    @PutMapping("/{orderId}/status")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateOrderStatus(@PathVariable Long orderId, @RequestBody String status) {
        orderService.updateOrderStatus(orderId, status);
    }

    private User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }
}

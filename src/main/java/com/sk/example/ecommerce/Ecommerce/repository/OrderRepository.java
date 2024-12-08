package com.sk.example.ecommerce.Ecommerce.repository;

import com.sk.example.ecommerce.Ecommerce.entity.Order;
import com.sk.example.ecommerce.Ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByUser(User user);
}

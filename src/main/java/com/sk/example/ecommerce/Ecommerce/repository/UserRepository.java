package com.sk.example.ecommerce.Ecommerce.repository;

import com.sk.example.ecommerce.Ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}

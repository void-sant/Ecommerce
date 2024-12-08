package com.sk.example.ecommerce.Ecommerce.repository;

import com.sk.example.ecommerce.Ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByCategoryContaining(String category);

    List<Product> findByNameContaining(String name);
}

package com.sk.example.ecommerce.Ecommerce.service;

import com.sk.example.ecommerce.Ecommerce.entity.Product;
import com.sk.example.ecommerce.Ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> listProducts(String name, String category) {
        if (name != null && category != null) {
            return productRepository.findByCategoryContaining(category);
        } else if (name != null) {
            return productRepository.findByNameContaining(name);
        }
        return productRepository.findAll();
    }

    public Product updateProduct(Long productId, Product productDetails) {
        Product product = productRepository.findById(productId).orElseThrow();
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setCategory(productDetails.getCategory());
        product.setDescription(productDetails.getDescription());
        product.setStock(productDetails.getStock());
        return productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow();
        productRepository.delete(product);
    }

}

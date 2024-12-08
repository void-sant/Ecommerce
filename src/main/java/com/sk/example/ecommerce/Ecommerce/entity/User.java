package com.sk.example.ecommerce.Ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;
    private String email;

/*    @Enumerated(EnumType.STRING)
    private Role role; // Admin, Customer

    public enum Role {
        ADMIN, CUSTOMER
    }
*/
}

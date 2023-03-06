package com.example.gds_backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", length = 30, unique = true)
    private String name;

    @Column(name = "price")
    private float price;

    @Column(name = "description")
    private String description;
}

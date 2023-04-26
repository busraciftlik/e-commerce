package com.busraciftlik.entities;


import com.busraciftlik.entities.Category;
import com.busraciftlik.entities.enums.Status;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity;
    private double price;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Category> categories = new HashSet<>();

}


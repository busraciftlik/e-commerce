package com.busraciftlik.business.dto.requests.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
    private int id;
    private List<Integer> categoryIds;
    private String name;
    private int quantity;
    private double price;
    private String description;
}

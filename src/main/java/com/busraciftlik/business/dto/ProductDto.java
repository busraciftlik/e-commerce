package com.busraciftlik.business.dto;

import com.busraciftlik.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {
    private String name;
    private double price;
    private String description;
    private Status status;
}

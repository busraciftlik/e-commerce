package com.busraciftlik.business.dto.responses.get;

import com.busraciftlik.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductsResponse {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private String description;
    private Status status;
}

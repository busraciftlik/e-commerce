package com.busraciftlik.business.dto.responses.get;

import com.busraciftlik.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetProductResponse {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private String description;
    private Status status;
}

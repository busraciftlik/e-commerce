package com.busraciftlik.business.dto.requests.update;

import com.busraciftlik.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {
    private String name;
    private int quantity;
    private double price;
    private String description;
    private Status status;
}

package com.busraciftlik.business.dto.requests.create;

import com.busraciftlik.entities.enums.Status;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    private List<Integer> categoryIds;

    @Size(min = 1 , max = 20)
    @NotBlank
    @NotNull
    private String name;
    private int quantity;

    @Min(value = 1)
    private double price;

    @Size(max = 35)
    private String description;

    private Status status;
}

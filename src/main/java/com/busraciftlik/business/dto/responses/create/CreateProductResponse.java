package com.busraciftlik.business.dto.responses.create;

import com.busraciftlik.business.dto.CategoryDto;
import com.busraciftlik.business.dto.requests.create.CreateCategoryRequest;
import com.busraciftlik.entities.Category;
import com.busraciftlik.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductResponse {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private String description;
    private Status status;
    private Set<CategoryDto> categories;
}

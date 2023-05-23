package com.busraciftlik.business.dto.responses.create;

import com.busraciftlik.business.dto.ProductDto;
import com.busraciftlik.business.dto.requests.create.CreateProductRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateSaleResponse {
    private int id;
    private Set<ProductDto> products;
    private double totalPrice;
}

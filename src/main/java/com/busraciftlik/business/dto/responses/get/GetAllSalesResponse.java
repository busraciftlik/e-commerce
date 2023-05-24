package com.busraciftlik.business.dto.responses.get;

import com.busraciftlik.business.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllSalesResponse {
    private int id;
    private Set<ProductDto> products;
    private double totalPrice;

}


package com.busraciftlik.business.dto.requests.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CreateSaleRequest {
    private List<Integer> productIds;
}

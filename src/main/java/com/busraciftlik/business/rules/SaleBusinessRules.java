package com.busraciftlik.business.rules;

import com.busraciftlik.repository.abstracts.SaleRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaleBusinessRules {
    private final SaleRepository repository;

    public void checkIfSaleExists(int id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Sale not found");
        }
    }
}

package com.busraciftlik.business.rules;

import com.busraciftlik.core.exceptions.BusinessException;
import com.busraciftlik.repository.abstracts.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SaleBusinessRules {
    private final SaleRepository repository;

    public void checkIfSaleExists(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException("Sale not found");
        }
    }
}

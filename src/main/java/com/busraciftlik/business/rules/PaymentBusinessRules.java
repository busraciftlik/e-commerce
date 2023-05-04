package com.busraciftlik.business.rules;

import com.busraciftlik.core.exceptions.BusinessException;
import com.busraciftlik.repository.abstracts.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentBusinessRules {
    private final PaymentRepository repository;

    public void checkIfPaymentExists(int id){
        if(!repository.existsById(id)){
            throw new BusinessException("Payment not found");
        }
    }
}

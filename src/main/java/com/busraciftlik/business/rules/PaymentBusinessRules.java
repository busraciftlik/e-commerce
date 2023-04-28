package com.busraciftlik.business.rules;

import com.busraciftlik.repository.abstracts.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentBusinessRules {
    private final PaymentRepository repository;

    public void checkIfIdExists(int id){
        if(!repository.existsById(id)){
            throw new RuntimeException("id not found");
        }
    }
}
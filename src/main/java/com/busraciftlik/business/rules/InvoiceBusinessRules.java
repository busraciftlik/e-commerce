package com.busraciftlik.business.rules;

import com.busraciftlik.common.constants.Message;
import com.busraciftlik.core.exceptions.BusinessException;
import com.busraciftlik.repository.abstracts.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InvoiceBusinessRules {
    private final InvoiceRepository repository;

    public void checkIfInvoiceExists(int id){
        if(!repository.existsById(id)){
            throw new BusinessException(Message.Invoice.NOT_EXISTS);
        }
    }
}

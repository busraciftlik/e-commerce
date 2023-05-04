package com.busraciftlik.business.rules;

import com.busraciftlik.repository.abstracts.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InvoiceBusinessRules {
    private final InvoiceRepository repository;

}

package com.busraciftlik.business.concretes;

import com.busraciftlik.business.abstracts.InvoiceService;
import com.busraciftlik.business.dto.requests.create.CreateInvoiceRequest;
import com.busraciftlik.business.dto.responses.create.CreateInvoiceResponse;
import com.busraciftlik.business.dto.responses.get.GetAllInvoicesResponse;
import com.busraciftlik.business.dto.responses.get.GetInvoiceResponse;
import com.busraciftlik.business.dto.responses.update.UpdateInvoiceRequest;
import com.busraciftlik.business.dto.responses.update.UpdateInvoiceResponse;
import com.busraciftlik.business.rules.InvoiceBusinessRules;
import com.busraciftlik.repository.abstracts.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {
    private final InvoiceRepository repository;
    private final ModelMapper mapper;
    private final InvoiceBusinessRules rules;

    @Override
    public List<GetAllInvoicesResponse> getAll() {
        return null;
    }

    @Override
    public GetInvoiceResponse getById(int id) {
        return null;
    }

    @Override
    public CreateInvoiceResponse add(CreateInvoiceRequest request) {
        return null;
    }

    @Override
    public UpdateInvoiceResponse update(int id, UpdateInvoiceRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}

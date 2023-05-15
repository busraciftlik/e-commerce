package com.busraciftlik.business.concretes;

import com.busraciftlik.business.abstracts.InvoiceService;
import com.busraciftlik.business.dto.requests.create.CreateInvoiceRequest;
import com.busraciftlik.business.dto.responses.create.CreateInvoiceResponse;
import com.busraciftlik.business.dto.responses.get.GetAllInvoicesResponse;
import com.busraciftlik.business.dto.responses.get.GetInvoiceResponse;
import com.busraciftlik.business.dto.responses.update.UpdateInvoiceRequest;
import com.busraciftlik.business.dto.responses.update.UpdateInvoiceResponse;
import com.busraciftlik.business.rules.InvoiceBusinessRules;
import com.busraciftlik.entities.Invoice;
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
        List<Invoice> invoices = repository.findAll();
        List<GetAllInvoicesResponse> responses = invoices
                .stream()
                .map(invoice -> mapper.map(invoice, GetAllInvoicesResponse.class))
                .toList();

        return responses;
    }

    @Override
    public GetInvoiceResponse getById(int id) {
        rules.checkIfInvoiceExists(id);
        Invoice invoice = repository.findById(id).orElseThrow();

        return mapper.map(invoice, GetInvoiceResponse.class);

    }

    @Override
    public CreateInvoiceResponse add(CreateInvoiceRequest request) {
        Invoice invoice = mapper.map(request, Invoice.class);
        invoice.setId(0);
        repository.save(invoice);

        return mapper.map(invoice, CreateInvoiceResponse.class);
    }

    @Override
    public UpdateInvoiceResponse update(int id, UpdateInvoiceRequest request) {
        rules.checkIfInvoiceExists(id);
        Invoice invoice = mapper.map(request, Invoice.class);
        invoice.setId(id);
        repository.save(invoice);

        return mapper.map(invoice, UpdateInvoiceResponse.class);
    }

    @Override
    public void delete(int id) {
        rules.checkIfInvoiceExists(id);
        repository.deleteById(id);
    }
}

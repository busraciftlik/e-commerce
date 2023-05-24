package com.busraciftlik.api.controllers;


import com.busraciftlik.business.abstracts.InvoiceService;
import com.busraciftlik.business.dto.requests.create.CreateInvoiceRequest;
import com.busraciftlik.business.dto.requests.update.UpdateInvoiceRequest;
import com.busraciftlik.business.dto.responses.create.CreateInvoiceResponse;
import com.busraciftlik.business.dto.responses.get.GetAllInvoicesResponse;
import com.busraciftlik.business.dto.responses.get.GetInvoiceResponse;
import com.busraciftlik.business.dto.responses.update.UpdateInvoiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
    private final InvoiceService service;

    @GetMapping()
    List<GetAllInvoicesResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    GetInvoiceResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    CreateInvoiceResponse add(@RequestBody CreateInvoiceRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    UpdateInvoiceResponse update(@PathVariable int id, @RequestBody UpdateInvoiceRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable int id) {
        service.delete(id);
    }
}

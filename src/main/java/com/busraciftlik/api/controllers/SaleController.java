package com.busraciftlik.api.controllers;

import com.busraciftlik.business.abstracts.SaleService;
import com.busraciftlik.business.dto.requests.create.CreateSaleRequest;
import com.busraciftlik.business.dto.requests.update.UpdateSaleRequest;
import com.busraciftlik.business.dto.responses.create.CreateSaleResponse;
import com.busraciftlik.business.dto.responses.get.GetAllSalesResponse;
import com.busraciftlik.business.dto.responses.get.GetSaleResponse;
import com.busraciftlik.business.dto.responses.update.UpdateSaleResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/sales")
public class SaleController {
    private final SaleService service;

    @GetMapping()
    List<GetAllSalesResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    GetSaleResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    CreateSaleResponse add(@RequestBody CreateSaleRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    UpdateSaleResponse update(@PathVariable int id, @RequestBody UpdateSaleRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable int id) {
        service.delete(id);
    }
}

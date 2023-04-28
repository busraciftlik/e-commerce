package com.busraciftlik.api.controllers;

import com.busraciftlik.business.abstracts.PaymentService;
import com.busraciftlik.business.dto.requests.create.CreatePaymentRequest;
import com.busraciftlik.business.dto.requests.update.UpdatePaymentRequest;
import com.busraciftlik.business.dto.responses.create.CreatePaymentResponse;
import com.busraciftlik.business.dto.responses.get.GetAllPaymentsResponse;
import com.busraciftlik.business.dto.responses.get.GetPaymentResponse;
import com.busraciftlik.business.dto.responses.update.UpdatePaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@AllArgsConstructor
public class PaymentController {
    private final PaymentService service;

    @GetMapping()
    List<GetAllPaymentsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    GetPaymentResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    CreatePaymentResponse add(@RequestBody CreatePaymentRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    UpdatePaymentResponse update(@PathVariable int id ,@RequestBody UpdatePaymentRequest request){
        return service.update(id,request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable int id){
        service.delete(id);
    }

}

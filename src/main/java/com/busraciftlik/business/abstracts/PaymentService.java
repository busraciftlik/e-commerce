package com.busraciftlik.business.abstracts;


import com.busraciftlik.business.dto.requests.CreateProductPaymentRequest;
import com.busraciftlik.business.dto.requests.create.CreatePaymentRequest;
import com.busraciftlik.business.dto.requests.update.UpdatePaymentRequest;
import com.busraciftlik.business.dto.responses.create.CreatePaymentResponse;
import com.busraciftlik.business.dto.responses.get.GetAllPaymentsResponse;
import com.busraciftlik.business.dto.responses.get.GetPaymentResponse;
import com.busraciftlik.business.dto.responses.update.UpdatePaymentResponse;
import com.busraciftlik.entities.Product;

import java.util.List;


public interface PaymentService {
    List<GetAllPaymentsResponse> getAll();
    GetPaymentResponse getById(int id);
    CreatePaymentResponse add(CreatePaymentRequest request);
    UpdatePaymentResponse update(int id, UpdatePaymentRequest request);
    void delete(int id);
    void processProductPayment(CreateProductPaymentRequest request);
}

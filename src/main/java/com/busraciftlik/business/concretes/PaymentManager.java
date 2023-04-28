package com.busraciftlik.business.concretes;

import com.busraciftlik.business.abstracts.PaymentService;
import com.busraciftlik.business.dto.requests.create.CreatePaymentRequest;
import com.busraciftlik.business.dto.requests.update.UpdatePaymentRequest;
import com.busraciftlik.business.dto.responses.create.CreatePaymentResponse;
import com.busraciftlik.business.dto.responses.get.GetAllPaymentsResponse;
import com.busraciftlik.business.dto.responses.get.GetPaymentResponse;
import com.busraciftlik.business.dto.responses.update.UpdatePaymentResponse;
import com.busraciftlik.business.rules.PaymentBusinessRules;
import com.busraciftlik.entities.Payment;
import com.busraciftlik.repository.abstracts.PaymentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PaymentManager implements PaymentService {
    private final PaymentRepository repository;
    private final ModelMapper mapper;
    private final PaymentBusinessRules rules;

    @Override
    public List<GetAllPaymentsResponse> getAll() {
        List<Payment> payments = repository.findAll();
        return payments
                .stream()
                .map(payment -> mapper.map(payment, GetAllPaymentsResponse.class))
                .toList();
    }

    @Override
    public GetPaymentResponse getById(int id) {
        rules.checkIfIdExists(id);
        Payment payment = repository.findById(id).orElseThrow();
        return mapper.map(payment,GetPaymentResponse.class);
    }

    @Override
    public CreatePaymentResponse add(CreatePaymentRequest request) {
        Payment payment = mapper.map(request, Payment.class);
        payment.setId(0);
        Payment savedPayment = repository.save(payment);
        return mapper.map(savedPayment,CreatePaymentResponse.class);
    }

    @Override
    public UpdatePaymentResponse update(int id, UpdatePaymentRequest request) {
        rules.checkIfIdExists(id);
        Payment payment = mapper.map(request,Payment.class);
        payment.setId(id);
        Payment savedPayment = repository.save(payment);
        return mapper.map(savedPayment,UpdatePaymentResponse.class);
    }

    @Override
    public void delete(int id) {
        rules.checkIfIdExists(id);
        repository.deleteById(id);
    }


}

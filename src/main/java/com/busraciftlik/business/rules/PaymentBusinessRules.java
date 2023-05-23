package com.busraciftlik.business.rules;

import com.busraciftlik.business.dto.requests.CreateProductPaymentRequest;
import com.busraciftlik.business.dto.requests.PaymentRequest;
import com.busraciftlik.common.constants.Message;
import com.busraciftlik.core.exceptions.BusinessException;
import com.busraciftlik.repository.abstracts.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentBusinessRules {
    private final PaymentRepository repository;

    public void checkIfPaymentExists(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Message.Payment.NOT_FOUND);
        }
    }

    public void checkIfPaymentIsValid(CreateProductPaymentRequest request) {
        if (!repository.existsByCardNumberAndCardHolderAndCardExpirationYearAndCardExpirationMonthAndCardCvv(
                request.getCardNumber(),
                request.getCardHolder(),
                request.getCardExpirationYear(),
                request.getCardExpirationMonth(),
                request.getCardCvv()
        )) {
            throw new BusinessException(Message.Payment.NOT_A_VALID_PAYMENT);
        }
    }

    public void checkIfBalanceEnough(double balance, double price){
        if (balance < price) {
            throw new BusinessException(Message.Payment.NOT_ENOUGH_MONEY);
        }
    }
}

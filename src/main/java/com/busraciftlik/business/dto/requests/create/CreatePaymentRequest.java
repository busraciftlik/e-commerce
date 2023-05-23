package com.busraciftlik.business.dto.requests.create;

import com.busraciftlik.business.dto.requests.PaymentRequest;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentRequest extends PaymentRequest {
    @Min(value = 1)
    private double balance;
}

package com.busraciftlik.business.dto.requests.create;

import com.busraciftlik.business.dto.requests.PaymentRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateSaleRequest {
    private List<Integer> productIds;
    private PaymentRequest paymentRequest;

}

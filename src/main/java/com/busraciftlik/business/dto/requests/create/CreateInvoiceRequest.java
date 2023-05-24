package com.busraciftlik.business.dto.requests.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class CreateInvoiceRequest {
    private String cardHolder;
    private String productName;
    private double price;
}

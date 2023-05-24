package com.busraciftlik.business.dto.responses.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInvoiceResponse {
    private int id;
    private String cardHolder;
    private String productName;
    private double price;
    private double totalPrice;
    private LocalDateTime invoiceDate;
}

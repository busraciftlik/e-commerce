package com.busraciftlik.business.dto.responses.get;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class GetAllInvoicesResponse {
    private int id;
    private String cardHolder;
    private String productName;
    private int quantity;
    private double price;
    private double totalPrice;
    private LocalDateTime invoiceDate;
}

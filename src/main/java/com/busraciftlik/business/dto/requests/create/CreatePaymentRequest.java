package com.busraciftlik.business.dto.requests.create;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentRequest {
    @NotNull
    @NotBlank(message = "Card number cannot be left blank")
    @Size(min = 16, max = 16, message = "Card number must consist of 16 digits")
    private String cardNumber;

    @NotBlank
    @Size(min = 5)
    private String cardHolder;

    @Min((2023))
    private int cardExpirationYear;

    @Min(1)
    @Max(12)
    private int cardExpirationMonth;

    @Size(min = 3, max = 3 )
    private String cardCvv;

    @Min(value = 1)
    private double balance;
}

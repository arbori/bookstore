package com.bookstore.service.model.gbooks;

import javax.json.bind.annotation.JsonbProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price {
    @JsonbProperty("amount")
    private Double amount;
    @JsonbProperty("amountInMicros")
    private Double amountInMicros;
    @JsonbProperty("currencyCode")
    private String currencyCode;
}

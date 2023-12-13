package com.bookstore.service.model.gbooks;

import javax.json.bind.annotation.JsonbProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Offer {
    @JsonbProperty("finskyOfferType")
    private Integer finskyOfferType;
    @JsonbProperty("listPrice")
    private Price listPrice;
    @JsonbProperty("retailPrice")
    private Price retailPrice;
}

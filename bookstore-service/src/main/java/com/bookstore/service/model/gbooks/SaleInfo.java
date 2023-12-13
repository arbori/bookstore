package com.bookstore.service.model.gbooks;

import java.util.List;

import javax.json.bind.annotation.JsonbProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleInfo {
    @JsonbProperty("country")
    private String country;
    @JsonbProperty("saleability")
    private String saleability;
    @JsonbProperty("isEbook")
    private Boolean isEbook;
    @JsonbProperty("listPrice")
    private Price listPrice;
    @JsonbProperty("retailPrice")
    private Price retailPrice;
    @JsonbProperty("buyLink")
    private String buyLink;
    @JsonbProperty("offers")
    private List<Offer> offers;
}

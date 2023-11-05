package com.bookstore.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleInfo {
    private String country;
    private String saleability;
    private Boolean isEbook;
}

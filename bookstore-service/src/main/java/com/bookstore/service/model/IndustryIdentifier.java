package com.bookstore.service.model;

import javax.json.bind.annotation.JsonbProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndustryIdentifier {
    @JsonbProperty("type")
    private String type;
    @JsonbProperty("identifier")
    private String identifier;
}

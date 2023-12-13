package com.bookstore.service.model.gbooks;

import javax.json.bind.annotation.JsonbProperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class Pdf {
    @JsonbProperty("isAvailable")
    private Boolean isAvailable;
    @JsonbProperty("acsTokenLink")
    private String acsTokenLink;
    @JsonbProperty("downloadLink")
    private String downloadLink;
}

package com.bookstore.service.model;

import javax.json.bind.annotation.JsonbProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReadingModes {
    @JsonbProperty("text")
    private boolean text;
    @JsonbProperty("image")
    private boolean image;
}

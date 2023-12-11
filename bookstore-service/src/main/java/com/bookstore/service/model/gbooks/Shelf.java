package com.bookstore.service.model.gbooks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.json.bind.annotation.JsonbProperty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shelf {
    @JsonbProperty("kind")
    private String kind;
    @JsonbProperty("totalItems")
    private Integer totalItems;
    @JsonbProperty("items")
    private List<Volume> items;
}

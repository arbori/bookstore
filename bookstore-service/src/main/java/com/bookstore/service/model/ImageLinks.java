package com.bookstore.service.model;

import javax.json.bind.annotation.JsonbProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageLinks {
    @JsonbProperty("smallThumbnail")
    private String smallThumbnail;
    @JsonbProperty("thumbnail")
    private String thumbnail;
}

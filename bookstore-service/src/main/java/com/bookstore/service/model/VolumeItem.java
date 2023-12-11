package com.bookstore.service.model;

import javax.json.bind.annotation.JsonbProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VolumeItem {
    @JsonbProperty("id")
    private String id;
    @JsonbProperty("title")
    private String title;
    @JsonbProperty("smallThumbnail")
    private String smallThumbnail;
    @JsonbProperty("thumbnail")
    private String thumbnail;
}

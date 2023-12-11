package com.bookstore.service.model.gbooks;

import javax.json.bind.annotation.JsonbProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Volume {
    @JsonbProperty("kind")
    private String kind;
    @JsonbProperty("id")
    private String id;
    @JsonbProperty("etag")
    private String etag;
    @JsonbProperty("selfLink")
    private String selfLink;
    @JsonbProperty("volumeInfo")
    private VolumeInfo volumeInfo;
    @JsonbProperty("saleInfo")
    private SaleInfo saleInfo;
    @JsonbProperty("accessInfo")
    private AccessInfo accessInfo;
    @JsonbProperty("searchInfo")
    private SearchInfo searchInfo;
}

package com.bookstore.service.model;

import javax.json.bind.annotation.JsonbProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryInfo {
    @JsonbProperty("query")
    private String query = "";
    @JsonbProperty("startIndex")
    private int startIndex; 
    @JsonbProperty("maxResults")
    private int maxResults;
}

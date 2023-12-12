package com.bookstore.service.model;

import java.util.List;
import java.util.ArrayList;
import javax.json.bind.annotation.JsonbProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VolumeList {
    public VolumeList(QueryInfo queryInfo) {
        this.queryInfo = queryInfo;
    }
    
    @JsonbProperty("queryInfo")
    private QueryInfo queryInfo;
    
    @JsonbProperty("items")
    private List<VolumeItem> items = new ArrayList<>();

    @JsonbProperty("isEmpty")
    public boolean isEmpty() {
        return items.isEmpty();
    }
}

package com.bookstore.service.model.gbooks;

import javax.json.bind.annotation.JsonbProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PanelizationSummary {
    @JsonbProperty("containsEpubBubbles")
    private boolean containsEpubBubbles;
    @JsonbProperty("containsImageBubbles")
    private boolean containsImageBubbles;
}

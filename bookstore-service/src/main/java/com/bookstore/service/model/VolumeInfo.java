package com.bookstore.service.model;

import java.util.List;

import javax.json.bind.annotation.JsonbProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VolumeInfo {
    @JsonbProperty("title")
    private String title;
    @JsonbProperty("authors")
    private List<String> authors;
    @JsonbProperty("publisher")
    private String publisher;
    @JsonbProperty("publishedDate")
    private String publishedDate;
    @JsonbProperty("description")
    private String description;
    @JsonbProperty("industryIdentifiers")
    private List<IndustryIdentifier> industryIdentifiers;
    @JsonbProperty("readingModes")
    private ReadingModes readingModes;
    @JsonbProperty("pageCount")
    private Integer pageCount;
    @JsonbProperty("printType")
    private String printType;
    @JsonbProperty("categories")
    private List<String> categories;
    @JsonbProperty("maturityRating")
    private String maturityRating;
    @JsonbProperty("allowAnonLogging")
    private Boolean allowAnonLogging;
    @JsonbProperty("contentVersion")
    private String contentVersion;
    @JsonbProperty("panelizationSummary")
    private PanelizationSummary panelizationSummary;
    @JsonbProperty("imageLinks")
    private ImageLinks imageLinks;
    @JsonbProperty("language")
    private String language;
    @JsonbProperty("previewLink")
    private String previewLink;
    @JsonbProperty("infoLink")
    private String infoLink;
    @JsonbProperty("canonicalVolumeLink")
    private String canonicalVolumeLink;

    @JsonbProperty("averageRating")
    private String averageRating;
    @JsonbProperty("ratingsCount")
    private String ratingsCount;
}

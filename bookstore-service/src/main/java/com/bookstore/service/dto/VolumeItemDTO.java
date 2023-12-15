package com.bookstore.service.dto;

public class VolumeItemDTO {
    public final String id;
    public final String title;
    public final String smallThumbnail;
    public final String thumbnail;
    public final Boolean favorite;

    public VolumeItemDTO(String id, String title, String smallThumbnail, String thumbnail, boolean favorite) {
        this.id = id;
        this.title = title;
        this.smallThumbnail = smallThumbnail;
        this.thumbnail = thumbnail;
        this.favorite = favorite;
    }
}

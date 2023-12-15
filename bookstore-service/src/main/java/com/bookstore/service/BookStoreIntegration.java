package com.bookstore.service;

import com.bookstore.service.dto.VolumeItemDTO;

public class BookStoreIntegration {
    static {
        System.loadLibrary("gbooksapi");
    }

    private static Long favoriteHandler = null;

    public BookStoreIntegration() {
        if(BookStoreIntegration.favoriteHandler == null) {
            favoriteHandler = startFavoriteRepository("/home/arbori/Source/java-workspace/bookstore/bookstore-web/src/main/resources/database/bookstore.db");
        }
    }

    public native String search(String query, int startIndex, int maxResults);

    public native long startFavoriteRepository(String filePath);

    private native void closeFavoriteRepository(long favoriteHandler);

    private native void updateFavorite(long favoriteHandler, VolumeItemDTO volume);

    private native boolean isFavorite(long favoriteHandler, String id);

    public void closeFavoriteRepository() {
        closeFavoriteRepository(favoriteHandler);
        favoriteHandler = null;
    }

    public void updateFavorite(VolumeItemDTO volume) {
        updateFavorite(favoriteHandler, volume);
    }

    public boolean isFavorite(String id) {
        return isFavorite(favoriteHandler, id);
    }
}

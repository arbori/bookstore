package com.bookstore.service;

import com.bookstore.service.model.VolumeItem;
import com.bookstore.service.model.VolumeList;

public interface BookStoreService {

    public VolumeList searchBooks(String query, int startIndex, int maxResults);

    public void updateFavorite(VolumeItem volume);

}

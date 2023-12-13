package com.bookstore.service;

import com.bookstore.service.model.VolumeList;

public interface BookStoreService {

    public VolumeList searchBooks(String query, int startIndex, int maxResults);

}

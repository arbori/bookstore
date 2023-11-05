package com.bookstore.service;

import com.bookstore.service.model.Shelf;

public interface BookStoreService {

    public Shelf searchBooks(String query, int startIndex, int maxResults);

}

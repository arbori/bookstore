package com.bookstore.service;

public class BookStoreIntegration {
    static {
        System.loadLibrary("gbooksapi");
    }

    public native String search(String query, int startIndex, int maxResults);
}

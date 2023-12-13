package com.bookstore.controller;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.service.BookStoreService;
import com.bookstore.service.model.VolumeList;

@RestController
public class BooksController {
    private BookStoreService bookStoreService;
    
    @Autowired
    public BooksController(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }

    @GetMapping("/gbooks/api/list")
	public VolumeList gbooksList(@QueryParam("query") String query, @QueryParam("startIndex") Integer startIndex, @QueryParam("maxResults") Integer maxResults) {
        return bookStoreService.searchBooks(query, 0, 12);
	}
}

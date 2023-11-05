package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.service.BookStoreService;
import com.bookstore.service.model.Shelf;

@RestController
public class BooksController {
    private BookStoreService bookStoreService;

    @Autowired
    public BooksController(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }

    @GetMapping("/gbooks/api/list")
	public Shelf gbooksList() {
		return bookStoreService.searchBooks("philosopher's stone harry potter", 0, 5);
	}
}

package com.bookstore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bookstore.service.BookStoreService;
import com.bookstore.service.BookStoreServiceImpl;

@Configuration
public class BookstoreWebConfig {
    @Bean
    public BookStoreService bookStoreService() {
        return new BookStoreServiceImpl();
    }
}

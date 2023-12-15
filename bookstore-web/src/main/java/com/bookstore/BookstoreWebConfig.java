package com.bookstore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bookstore.service.BookStoreService;
import com.bookstore.service.BookStoreServiceImpl;

@Configuration
public class BookstoreWebConfig implements WebMvcConfigurer {
    @Bean
    public BookStoreService bookStoreService() {
        return new BookStoreServiceImpl();
    }
}

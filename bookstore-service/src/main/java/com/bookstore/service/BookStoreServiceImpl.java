package com.bookstore.service;

import java.util.logging.Logger;
import java.util.logging.Level;

import com.bookstore.service.model.Shelf;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class BookStoreServiceImpl implements BookStoreService {
    private static Logger logger = Logger.getLogger(BookStoreServiceImpl.class.getName());
    
    private BookStoreIntegration integration = new BookStoreIntegration();

    @Override
    public Shelf searchBooks(String query, int startIndex, int maxResults) {
        String content = integration.search(query, startIndex, maxResults);
    
        ObjectMapper mapper = new ObjectMapper();
        
        Shelf shelf;

        try {
            shelf = mapper.readValue(content, Shelf.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            
            logger.log(Level.ALL, "Content was not unmarshalled", e);

            shelf = new Shelf();
        }

        return shelf;
    }
}

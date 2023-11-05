package com.bookstore.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bookstore.service.model.Shelf;

public class BookStoreServiceLayerTest {
    @Test
    public void bookStoreIntegrationShouldAnswerWithContent() {
        BookStoreIntegration integration = new BookStoreIntegration();

        String content = integration.search("philosopher's stone harry potter", 0, 5);

        System.out.println(content);

        assertTrue( content.startsWith("{") );
    }

    @Test
    public void bookStoreServiceImplShouldMarshallJson() {
        BookStoreServiceImpl service = new BookStoreServiceImpl();

        Shelf shelf = service.searchBooks("philosopher's stone harry potter", 0, 5);

        assertNotNull( shelf.getTotalItems() );
        assertTrue( shelf.getTotalItems() > 0 );
    }
}

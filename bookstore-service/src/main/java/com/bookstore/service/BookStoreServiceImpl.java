package com.bookstore.service;

import org.springframework.stereotype.Service;

import com.bookstore.service.model.QueryInfo;
import com.bookstore.service.model.VolumeList;
import com.bookstore.service.model.VolumeListFactory;

/**
 * 
 */
@Service
public class BookStoreServiceImpl implements BookStoreService {
    private BookStoreIntegration integration = new BookStoreIntegration();

    @Override
    public VolumeList searchBooks(String query, int startIndex, int maxResults) {
        if(query == null || query.isEmpty()) {
            return new VolumeList();
        }

        String content = integration.search(query, startIndex, maxResults);
    
        return VolumeListFactory.build(content, new QueryInfo(query, startIndex, maxResults));
    }
}

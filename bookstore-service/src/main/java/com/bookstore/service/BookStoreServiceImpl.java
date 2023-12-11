package com.bookstore.service;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.bookstore.service.model.QueryInfo;
import com.bookstore.service.model.VolumeItem;
import com.bookstore.service.model.VolumeList;
import com.bookstore.service.model.gbooks.Shelf;
import com.bookstore.service.model.gbooks.Volume;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 */
@Service
public class BookStoreServiceImpl implements BookStoreService {
    private static Logger logger = Logger.getLogger(BookStoreServiceImpl.class.getName());
    
    private BookStoreIntegration integration = new BookStoreIntegration();

    @Override
    public VolumeList searchBooks(String query, int startIndex, int maxResults) {
        String content = integration.search(query, startIndex, maxResults);
    
        ObjectMapper mapper = new ObjectMapper();
        
        VolumeList volumeList = new VolumeList();
        volumeList.setQueryInfo(new QueryInfo(query, startIndex, maxResults));

        if(query == null || query.isEmpty()) {
            return volumeList;
        }

        Shelf shelf = new Shelf();

        try {
            shelf = mapper.readValue(content, Shelf.class);

            boolean hasImage;

            for(Volume volume: shelf.getItems()) {
                hasImage = volume.getVolumeInfo().getImageLinks() != null;

                volumeList.getItems().add(
                    new VolumeItem(
                        volume.getId(), 
                        volume.getVolumeInfo().getTitle(), 
                        hasImage ? volume.getVolumeInfo().getImageLinks().getSmallThumbnail() : "", 
                        hasImage ? volume.getVolumeInfo().getImageLinks().getThumbnail() : "")
                );
            }

        } catch (JsonProcessingException e) {
            logger.warning(e.getMessage());
            logger.warning(content);
        }

        return volumeList;
    }
}

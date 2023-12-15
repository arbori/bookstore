package com.bookstore.service;

import org.springframework.stereotype.Service;

import com.bookstore.service.dto.VolumeItemDTO;
import com.bookstore.service.model.QueryInfo;
import com.bookstore.service.model.VolumeItem;
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
    
        VolumeList volumeList = VolumeListFactory.build(content, new QueryInfo(query, startIndex, maxResults));

        volumeList.getItems().forEach(volume -> {
            volume.setFavorite(this.isFavorite(volume.getId()));
        });

        return volumeList;
    }

    public void updateFavorite(VolumeItem volume) {
        VolumeItemDTO volumeItemDTO = new VolumeItemDTO(
            volume.getId(), 
            volume.getTitle(), 
            volume.getSmallThumbnail(), 
            volume.getThumbnail(),
            volume.getFavorite());

        integration.updateFavorite(volumeItemDTO);
    }

    private boolean isFavorite(String id) {
        return integration.isFavorite(id);
    }
}

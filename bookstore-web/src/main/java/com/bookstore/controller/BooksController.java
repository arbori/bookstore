package com.bookstore.controller;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.service.BookStoreService;
import com.bookstore.service.model.FavoriteFactory;
import com.bookstore.service.model.FavoriteResponse;
import com.bookstore.service.model.VolumeItem;
import com.bookstore.service.model.VolumeList;

@RestController
public class BooksController {
    private BookStoreService bookStoreService;

    @Autowired
    public BooksController(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }

    @GetMapping(value = "/gbooks/api/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public VolumeList gbooksList(@QueryParam("query") String query, @QueryParam("startIndex") Integer startIndex,
            @QueryParam("maxResults") Integer maxResults) {
        return bookStoreService.searchBooks(query, 0, 12);
    }

    @PutMapping(value = "/gbooks/api/favorite", produces = MediaType.APPLICATION_JSON_VALUE)
    public FavoriteResponse gbooksFavorite(@RequestBody String favoritejson) {
        FavoriteResponse favoriteResponse = new FavoriteResponse();

        try {
            VolumeItem volume = FavoriteFactory.build(favoritejson);

            bookStoreService.updateFavorite(volume);

            favoriteResponse.setId(volume.getId());
            favoriteResponse.setMessage("success");
        } catch (Exception e) {
            favoriteResponse.setMessage(e.getMessage());
        }

        return favoriteResponse;
    }
}

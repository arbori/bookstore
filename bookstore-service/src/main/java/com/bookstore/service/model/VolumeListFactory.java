package com.bookstore.service.model;

import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.logging.Level;

public class VolumeListFactory {
    private static Logger logger = Logger.getLogger(VolumeListFactory.class.getName());

    private static final String VOLUME_INFO = "volumeInfo";
    private static final String IMAGE_LINKS = "imageLinks";
    private static final String SMALL_THUMBNAIL = "smallThumbnail";
    private static final String THUMBNAIL = "Thumbnail";

    private VolumeListFactory() {

    }

    public static VolumeList build(String content, QueryInfo queryInfo) {
        VolumeList result = new VolumeList(queryInfo);

        try {
            JSONObject jo = new JSONObject(content);

            JSONArray itemsJson = jo.getJSONArray("items");

            for(int i = 0; i < itemsJson.length();i++) {
                JSONObject volumeJson = itemsJson.getJSONObject(i);

                result.getItems().add(
                    new VolumeItem(
                        getId(volumeJson),
                        getTitle(volumeJson),
                        getSmallThumbnail(volumeJson),
                        getThumbnail(volumeJson),
                        false
                ));
            }
        } catch(JSONException je) {
            logger.log(Level.ALL, je.getMessage());
        }

        return result;
    }

    private static String getId(JSONObject volumeJson) {
        String id;

        try {
            id = volumeJson.getString("id");
        } 
        catch(JSONException je) {
            id = null;
        }

        return id;
    }

    private static String getTitle(JSONObject volumeJson) {
        String title;

        try {
            JSONObject volumeInfo = volumeJson.getJSONObject(VOLUME_INFO);
            title = volumeInfo.getString("title");
        } 
        catch(JSONException je) {
            title = null;
        }

        return title;
    }

    private static String getSmallThumbnail(JSONObject volumeJson) {
        String smallThumbnail;

        try {
            JSONObject volumeInfo = volumeJson.getJSONObject(VOLUME_INFO);
            JSONObject imageLinks = volumeInfo.getJSONObject(IMAGE_LINKS);
            smallThumbnail = imageLinks.getString(SMALL_THUMBNAIL);
        } 
        catch(JSONException je) {
            smallThumbnail = null;
        }

        return smallThumbnail;
    }

    private static String getThumbnail(JSONObject volumeJson) {
        String thumbnail;

        try {
            JSONObject volumeInfo = volumeJson.getJSONObject(VOLUME_INFO);
            JSONObject imageLinks = volumeInfo.getJSONObject(IMAGE_LINKS);
            thumbnail = imageLinks.getString(THUMBNAIL);
        } 
        catch(JSONException je) {
            thumbnail = null;
        }

        return thumbnail;
    }
}

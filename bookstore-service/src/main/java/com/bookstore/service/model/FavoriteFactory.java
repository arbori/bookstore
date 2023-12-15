package com.bookstore.service.model;

import org.json.JSONException;
import org.json.JSONObject;

public class FavoriteFactory {
    private FavoriteFactory() {
    }

    public static VolumeItem build(String content) {
        JSONObject jo = new JSONObject(content);

        return new VolumeItem(
            getId(jo),
            getTitle(jo),
            getSmallThumbnail(jo),
            getThumbnail(jo),
            false
        );
    }

    private static String getId(JSONObject jo) {
        try {
            return jo.getString("id");
        } 
        catch(JSONException je) {
            return null;
        }
    }

    private static String getTitle(JSONObject jo) {
        try {
            return jo.getString("title");
        } 
        catch(JSONException je) {
            return null;
        }

    }

    private static String getSmallThumbnail(JSONObject jo) {
        try {
            return jo.getString("smallThumbnail");
        } 
        catch(JSONException je) {
            return null;
        }
    }

    private static String getThumbnail(JSONObject jo) {
        try {
            return jo.getString("thumbnail");
        } 
        catch(JSONException je) {
            return null;
        }
    }
}

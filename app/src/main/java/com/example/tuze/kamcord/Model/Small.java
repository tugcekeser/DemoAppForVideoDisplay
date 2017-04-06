
package com.example.tuze.kamcord.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Parcel
public class Small {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Small() {
    }

    public Small(JSONObject jsonObject) {
        try {
            this.url = jsonObject.getString("small");
            this.width = jsonObject.getInt("width");
            this.height = jsonObject.getInt("height");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

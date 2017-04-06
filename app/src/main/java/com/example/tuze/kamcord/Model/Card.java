
package com.example.tuze.kamcord.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Parcel
public class Card {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("shotCardData")
    @Expose
    private ShotCardData shotCardData;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ShotCardData getShotCardData() {
        return shotCardData;
    }

    public void setShotCardData(ShotCardData shotCardData) {
        this.shotCardData = shotCardData;
    }

    public Card() {
    }

    public Card(JSONObject jsonObject) {
        try {
            this.type = jsonObject.getString("type");
            this.shotCardData = new ShotCardData(jsonObject.getJSONObject("shotCardData"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}


package com.example.tuze.kamcord.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Parcel
public class Play {

    @SerializedName("mp4")
    @Expose
    private String mp4;

    public String getMp4() {
        return mp4;
    }

    public void setMp4(String mp4) {
        this.mp4 = mp4;
    }

    public Play() {
    }

    public Play(JSONObject jsonObject) {
        try {
            this.mp4 = jsonObject.getString("mp4");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}

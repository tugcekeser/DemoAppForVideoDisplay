
package com.example.tuze.kamcord.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Parcel
public class Badgesv2 {

    @SerializedName("small")
    @Expose
    private Small small;
    @SerializedName("medium")
    @Expose
    private Medium medium;
    @SerializedName("large")
    @Expose
    private Large large;

    public Small getSmall() {
        return small;
    }

    public void setSmall(Small small) {
        this.small = small;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public Large getLarge() {
        return large;
    }

    public void setLarge(Large large) {
        this.large = large;
    }

    public Badgesv2(){}

    public Badgesv2(JSONObject jsonObject) {
        try {
            this.small = new Small(jsonObject.getJSONObject("small"));
            this.medium = new Medium(jsonObject.getJSONObject("medium"));
            this.large = new Large(jsonObject.getJSONObject("large"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}

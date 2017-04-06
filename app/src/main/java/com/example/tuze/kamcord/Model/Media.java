
package com.example.tuze.kamcord.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Media {

    @SerializedName("checksum")
    @Expose
    private String checksum;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("feedId")
    @Expose
    private String feedId;
    @SerializedName("cards")
    @Expose
    private List<Card> cards = null;
    @SerializedName("nextPage")
    @Expose
    private String nextPage;

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFeedId() {
        return feedId;
    }

    public void setFeedId(String feedId) {
        this.feedId = feedId;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    public Media() {
    }

    public Media(JSONObject jsonObject) {
        try {
            this.checksum = jsonObject.getString("checksum");
            this.type = jsonObject.getString("type");
            this.feedId = jsonObject.getString("feedId");
            this.nextPage = jsonObject.getString("nextPage");
            this.cards = fromCardJSONArray(jsonObject.getJSONArray("cards"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Card> fromCardJSONArray(JSONArray array) {
        ArrayList<Card> results = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            try {
                results.add(new Card(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

}

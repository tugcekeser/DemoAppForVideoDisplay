
package com.example.tuze.kamcord.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class ShotCardData {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("videoId")
    @Expose
    private String videoId;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("badgesv2")
    @Expose
    private List<Badgesv2> badgesv2 = null;
    @SerializedName("avatarThumbnail")
    @Expose
    private AvatarThumbnail avatarThumbnail;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("viewCount")
    @Expose
    private Integer viewCount;
    @SerializedName("heartCount")
    @Expose
    private Integer heartCount;
    @SerializedName("featured")
    @Expose
    private Boolean featured;
    @SerializedName("dismissed")
    @Expose
    private Boolean dismissed;
    @SerializedName("videoVisibility")
    @Expose
    private String videoVisibility;
    @SerializedName("play")
    @Expose
    private Play play;
    @SerializedName("shotThumbnail")
    @Expose
    private ShotThumbnail shotThumbnail;
    @SerializedName("shotBackground")
    @Expose
    private ShotBackground shotBackground;
    @SerializedName("screenshotId")
    @Expose
    private String screenshotId;
    @SerializedName("screenshotVisibility")
    @Expose
    private String screenshotVisibility;
    @SerializedName("screenshotFeatured")
    @Expose
    private Boolean screenshotFeatured;
    @SerializedName("videoType")
    @Expose
    private String videoType;
    @SerializedName("createdAt")
    @Expose
    private Integer createdAt;
    @SerializedName("audio")
    @Expose
    private Boolean audio;
    @SerializedName("tagline")
    @Expose
    private String tagline;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Badgesv2> getBadgesv2() {
        return badgesv2;
    }

    public void setBadgesv2(List<Badgesv2> badgesv2) {
        this.badgesv2 = badgesv2;
    }

    public AvatarThumbnail getAvatarThumbnail() {
        return avatarThumbnail;
    }

    public void setAvatarThumbnail(AvatarThumbnail avatarThumbnail) {
        this.avatarThumbnail = avatarThumbnail;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getHeartCount() {
        return heartCount;
    }

    public void setHeartCount(Integer heartCount) {
        this.heartCount = heartCount;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public Boolean getDismissed() {
        return dismissed;
    }

    public void setDismissed(Boolean dismissed) {
        this.dismissed = dismissed;
    }

    public String getVideoVisibility() {
        return videoVisibility;
    }

    public void setVideoVisibility(String videoVisibility) {
        this.videoVisibility = videoVisibility;
    }

    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }

    public ShotThumbnail getShotThumbnail() {
        return shotThumbnail;
    }

    public void setShotThumbnail(ShotThumbnail shotThumbnail) {
        this.shotThumbnail = shotThumbnail;
    }

    public ShotBackground getShotBackground() {
        return shotBackground;
    }

    public void setShotBackground(ShotBackground shotBackground) {
        this.shotBackground = shotBackground;
    }

    public String getScreenshotId() {
        return screenshotId;
    }

    public void setScreenshotId(String screenshotId) {
        this.screenshotId = screenshotId;
    }

    public String getScreenshotVisibility() {
        return screenshotVisibility;
    }

    public void setScreenshotVisibility(String screenshotVisibility) {
        this.screenshotVisibility = screenshotVisibility;
    }

    public Boolean getScreenshotFeatured() {
        return screenshotFeatured;
    }

    public void setScreenshotFeatured(Boolean screenshotFeatured) {
        this.screenshotFeatured = screenshotFeatured;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getAudio() {
        return audio;
    }

    public void setAudio(Boolean audio) {
        this.audio = audio;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public ShotCardData() {
    }

    public ShotCardData(JSONObject jsonObject) {
        try {
            this.id = jsonObject.getString("id");
            this.videoId = jsonObject.getString("videoId");
            this.username = jsonObject.getString("username");
            this.userId = jsonObject.getString("userId");
            this.color = jsonObject.getString("color");
            this.badgesv2 = fromBadgesv2JSONArray(jsonObject.getJSONArray("badgesv2"));
            this.avatarThumbnail = new AvatarThumbnail(jsonObject.getJSONObject("avatarThumbnail"));
            this.viewCount = jsonObject.getInt("viewCount");
            this.duration = jsonObject.getInt("duration");
            this.heartCount = jsonObject.getInt("heartCount");
            this.featured = jsonObject.getBoolean("featured");
            this.dismissed = jsonObject.getBoolean("dismissed");
            this.videoVisibility = jsonObject.getString("videoVisibility");
            this.play = new Play(jsonObject.getJSONObject("play"));
            this.shotBackground = new ShotBackground(jsonObject.getJSONObject("shotBackground"));
            this.shotThumbnail = new ShotThumbnail(jsonObject.getJSONObject("shotThumbnail"));
            this.screenshotId = jsonObject.getString("screenshotId");
            this.screenshotVisibility = jsonObject.getString("screenshotVisibility");
            this.screenshotFeatured = jsonObject.getBoolean("screenshotFeatured");
            this.videoType = jsonObject.getString("videoType");
            this.createdAt = jsonObject.getInt("createdAt");
            this.audio = jsonObject.getBoolean("audio");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Badgesv2> fromBadgesv2JSONArray(JSONArray array) {
        ArrayList<Badgesv2> results = new ArrayList<Badgesv2>();
        for (int i = 0; i < array.length(); i++) {
            try {
                results.add(new Badgesv2(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}

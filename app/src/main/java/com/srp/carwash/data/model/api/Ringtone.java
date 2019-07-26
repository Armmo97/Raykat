package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ringtone {

    @Expose
    @SerializedName("id")
    private String id;

    @Expose
    @SerializedName("categoryId")
    private String categoryId;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("artist")
    private String artist;

    @Expose
    @SerializedName("thumbnail")
    private String thumbnail;

    @Expose
    @SerializedName("viewCount")
    private int viewCount;

    @Expose
    @SerializedName("likeCount")
    private int likeCount;

    @Expose
    @SerializedName("senderId")
    private String senderId;

    @Expose
    @SerializedName("status")
    private String status;

    @Expose
    @SerializedName("registeredAt")
    private String registeredAt;


    public String getId() {
        return id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public int getViewCount() {
        return viewCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getStatus() {
        return status;
    }

    public String getRegisteredAt() {
        return registeredAt;
    }
}

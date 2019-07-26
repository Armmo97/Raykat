package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Launcher {

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
    @SerializedName("description")
    private String description;

    @Expose
    @SerializedName("viewCount")
    private int viewCount;

    @Expose
    @SerializedName("likeCount")
    private int likeCount;

    @Expose
    @SerializedName("status")
    private String status;

    @Expose
    @SerializedName("previewCount")
    private int previewCount;

    @Expose
    @SerializedName("Link")
    private String link;

    @Expose
    @SerializedName("rate")
    private String rate;

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

    public String getDescription() {
        return description;
    }

    public int getViewCount() {
        return viewCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public String getStatus() {
        return status;
    }

    public int getPreviewCount() {
        return previewCount;
    }

    public String getLink() {
        return link;
    }

    public String getRate() {
        return rate;
    }

    public String getRegisteredAt() {
        return registeredAt;
    }
}

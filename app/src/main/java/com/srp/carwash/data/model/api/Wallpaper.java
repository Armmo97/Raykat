package com.srp.carwash.data.model.api;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wallpaper implements Parcelable {

    @Expose
    @SerializedName("id")
    private String id;

    @Expose
    @SerializedName("categoryId")
    private String categoryId;

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
    private int status;

    @Expose
    @SerializedName("registeredAt")
    private String registeredAt;


    public String getId() {
        return id;
    }

    public String getCategoryId() {
        return categoryId;
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

    public int getStatus() {
        return status;
    }

    public String getRegisteredAt() {
        return registeredAt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.categoryId);
        dest.writeInt(this.viewCount);
        dest.writeInt(this.likeCount);
        dest.writeString(this.senderId);
        dest.writeInt(this.status);
        dest.writeString(this.registeredAt);
    }

    public Wallpaper() {
    }

    protected Wallpaper(Parcel in) {
        this.id = in.readString();
        this.categoryId = in.readString();
        this.viewCount = in.readInt();
        this.likeCount = in.readInt();
        this.senderId = in.readString();
        this.status = in.readInt();
        this.registeredAt = in.readString();
    }

    public static final Parcelable.Creator<Wallpaper> CREATOR = new Parcelable.Creator<Wallpaper>() {
        @Override
        public Wallpaper createFromParcel(Parcel source) {
            return new Wallpaper(source);
        }

        @Override
        public Wallpaper[] newArray(int size) {
            return new Wallpaper[size];
        }
    };
}

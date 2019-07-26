package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateProductRequest {

    @Expose
    @SerializedName("id")
    private String id;

    @Expose
    @SerializedName("type")
    private String type;

    public UpdateProductRequest(String id, String type) {
        this.id = id;
        this.type = type;
    }
}

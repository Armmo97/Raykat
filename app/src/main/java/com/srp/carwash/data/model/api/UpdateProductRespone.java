package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateProductRespone {

    @Expose
    @SerializedName("status")
    private String status;

    @Expose
    @SerializedName("status_message")
    private String statusMessage;

    public String getStatus() {
        return status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }
}

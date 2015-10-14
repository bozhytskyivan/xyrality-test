package com.covani.xyralitytest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Covani on 14.10.2015.
 */
public class WorldStatus {
    @SerializedName("id")
    private String id;
    @SerializedName("description")
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

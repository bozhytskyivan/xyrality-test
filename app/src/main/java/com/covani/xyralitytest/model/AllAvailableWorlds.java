package com.covani.xyralitytest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Covani on 14.10.2015.
 */
public class AllAvailableWorlds {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("mapURL")
    private String mapURL;
    @SerializedName("language")
    private String language;
    @SerializedName("url")
    private String url;
    @SerializedName("worldStatus")
    private WorldStatus worldStatus;
    @SerializedName("country")
    private String country;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMapURL() {
        return mapURL;
    }

    public void setMapURL(String mapURL) {
        this.mapURL = mapURL;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public WorldStatus getWorldStatus() {
        return worldStatus;
    }

    public void setWorldStatus(WorldStatus worldStatus) {
        this.worldStatus = worldStatus;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}

package com.covani.xyralitytest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Covani on 14.10.2015.
 */
public class GamesResponse {

    @SerializedName("allAvailableWorlds")
    private AllAvailableWorlds[] allAvailableWorlds;
    @SerializedName("serverVersion")
    private String serverVersion;

    public AllAvailableWorlds[] getAllAvailableWorlds() {
        return allAvailableWorlds;
    }

    public void setAllAvailableWorlds(AllAvailableWorlds[] allAvailableWorlds) {
        this.allAvailableWorlds = allAvailableWorlds;
    }

    public String getServerVersion() {
        return serverVersion;
    }

    public void setServerVersion(String serverVersion) {
        this.serverVersion = serverVersion;
    }
}

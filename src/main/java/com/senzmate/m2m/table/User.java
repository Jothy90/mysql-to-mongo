package com.senzmate.m2m.table;

/**
 * Created by john on 1/5/15.
 */
public class User {
    private String id;
    private String deviceId;

    public User(String id, String deviceId) {
        this.id = id;
        this.deviceId = deviceId;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}

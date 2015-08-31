package com.senzmate.m2m.document;

import org.springframework.data.annotation.Id;

/**
 * Created by john on 1/5/15.
 */
public class HistoryDocument {
    @Id
    private String id;
    private String deviceId;
    private String entry; //T:30;H:54
    private String date;

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

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "HistoryDocument{" +
                "id='" + id + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", entry='" + entry + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

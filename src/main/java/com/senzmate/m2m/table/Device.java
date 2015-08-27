package com.senzmate.m2m.table;

/**
 * Created by john on 10/30/14.
 */
public class Device {

    private String id;
    private String name;
    private Integer tboxId;
    private Integer lowTemp;
    private Integer highTemp;
    private Integer temperature;
    private Integer lowHum;
    private Integer highHum;
    private Integer humidity;
    private String pin;
    private String position;


    public Device(String id, String pin) {
        this.id = id;
        this.pin = pin;
    }

    public Device() {
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

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

    public Integer getLowTemp() {
        return lowTemp;
    }

    public void setLowTemp(Integer lowTemp) {
        this.lowTemp = lowTemp;
    }

    public Integer getHighTemp() {
        return highTemp;
    }

    public void setHighTemp(Integer highTemp) {
        this.highTemp = highTemp;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getLowHum() {
        return lowHum;
    }

    public void setLowHum(Integer lowHum) {
        this.lowHum = lowHum;
    }

    public Integer getHighHum() {
        return highHum;
    }

    public void setHighHum(Integer highHum) {
        this.highHum = highHum;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getTboxId() {
        return tboxId;
    }

    public void setTboxId(Integer tboxId) {
        this.tboxId = tboxId;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "Device{" +
                "lowTemp=" + lowTemp +
                ", highTemp=" + highTemp +
                ", temperature=" + temperature +
                ", lowHum=" + lowHum +
                ", highHum=" + highHum +
                ", humidity=" + humidity +
                '}';
    }
}

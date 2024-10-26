package com.smartcity.v2;


public abstract class Sensor {
    private final String serialNumber;

    public Sensor(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }


    public abstract int data();


}

package com.smartcity;

public abstract class Sensor {
    protected SerialNumber serialNumber;
    protected int dataUsage;

    public Sensor(String serialBase, int initialDataUsage) {
        this.serialNumber = new SerialNumber(serialBase);
        this.dataUsage = initialDataUsage;
    }

    public String getSerialNumber() {
        return serialNumber.getSerial();
    }

    public int getDataUsage() {
        return dataUsage;
    }

    public void registerDataUsage(int additionalData) {
        dataUsage += additionalData;
    }
}

package com.smartcity.v2;


public class RegularSensor extends Sensor {
    private int dataUsage;

    public RegularSensor(String serialNumber, int initialDataUsage) {
        super(serialNumber);
        this.dataUsage = initialDataUsage;
    }


    public void registerDataUsage(int additionalData) {
        dataUsage += additionalData;
    }

    @Override
    public int data() {
        return dataUsage;
    }

    @Override
    public String toString() {
        return "RegularSensor{serialNumber=" + getSerialNumber() + ", dataUsage= " + dataUsage + "}";
    }
}

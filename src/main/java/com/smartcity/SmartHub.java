package com.smartcity;

import java.util.HashMap;
import java.util.Map;

public class SmartHub extends Sensor {
    private final Map<String, Integer> connectedSensors = new HashMap<>();
    private final int numberOfConnectedSensors;

    public SmartHub(String serialBase, int initialDataUsage, int numberOfConnectedSensors) {
        super(serialBase, initialDataUsage);
        this.numberOfConnectedSensors = numberOfConnectedSensors;
        initializeConnectedSensors();
    }

    private void initializeConnectedSensors() {
        for (int i = 1; i <= numberOfConnectedSensors; i++) {
            String connectedSerial = new SerialNumber(serialNumber.getSerial(), i).getSerial();
            connectedSensors.put(connectedSerial, 0);
        }
    }

    public Integer getConnectedSensorDataUsage(String connectedSerial) {
        return connectedSensors.get(connectedSerial);
    }

    public void registerDataUsageOnConnectedSensor(String connectedSerial, int additionalData) {
        if (connectedSensors.containsKey(connectedSerial)) {
            connectedSensors.put(connectedSerial, connectedSensors.get(connectedSerial) + additionalData);
        } else {
            throw new IllegalArgumentException("Connected sensor with serial " + connectedSerial + " does not exist.");
        }
    }

    @Override
    public int getDataUsage() {
        int totalUsage = dataUsage;
        for (int usage : connectedSensors.values()) {
            totalUsage += usage;
        }
        return totalUsage;
    }
}

package com.smartcity.v2;

import java.util.ArrayList;
import java.util.List;

public class SmartHub extends Sensor {
    private List<Sensor> sensors = new ArrayList<>();

    public SmartHub(String serialNumber) {
        super(serialNumber);
    }

    @Override
    public int data() {
        int result = 0;
//        for (int i = 0; i < sensors.size(); i++) {
//            result += sensors.get(i).data();
//        }

        for (Sensor sensor : sensors) {
            result += sensor.data();
        }

        return result;

//        int sum = sensors.stream()
//                .map(Sensor::data)
//                .mapToInt(Integer::intValue)
//                .sum();
    }

    public void register(Sensor sensor) {
        if(sensors.contains(sensor)) {
            System.out.println("WARNING! Sensor is already connected!");
            return;
        }

        sensors.add(sensor);
    }

    @Override
    public String toString() {
        return "SmartHub{" +
                "sensors=" + sensorNumbers() +
                '}';
    }

    private String sensorNumbers() {
        String result = "[";
        String delimeter = "";
        for (int i = 0; i < sensors.size(); i++) {
            result += String.format("%s%s-%02d(%s)", delimeter, getSerialNumber(), i, sensors.get(i).getSerialNumber()) ;
            delimeter = ", ";
        }
        result += "]";

        return result;
    }
}

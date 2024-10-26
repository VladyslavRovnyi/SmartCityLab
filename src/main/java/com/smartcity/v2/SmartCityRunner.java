package com.smartcity.v2;

public class SmartCityRunner {
    public static void main(String[] args) {
        RegularSensor prettySensor = new RegularSensor("pretty-sensor", 123);
        System.out.println(prettySensor);

        SmartHub smartHub = new SmartHub("BIG-HUB");
        hubInfo(smartHub);

        smartHub.register(prettySensor);
        hubInfo(smartHub);

        RegularSensor poorSensor = new RegularSensor("poor", 1);
        System.out.println(poorSensor);

        smartHub.register(poorSensor);
        hubInfo(smartHub);

        poorSensor.registerDataUsage(20);
        hubInfo(smartHub);

        smartHub.register(poorSensor);
        hubInfo(smartHub);
    }

    private static void hubInfo(SmartHub smartHub) {
        System.out.println("-= " + smartHub.getSerialNumber() + " info =-");
        System.out.println(smartHub);
        System.out.println("BIG-HUB data == " + smartHub.data());
        System.out.println();
    }
}

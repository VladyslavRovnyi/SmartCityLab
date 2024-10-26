package com.smartcity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmartHubTest {

    @Test
    public void testIncreaseCommonAndThirdSensorDataUsage() {
        SmartHub hub = new SmartHub("SN-12345", 100, 5);
        hub.registerDataUsage(50);
        hub.registerDataUsageOnConnectedSensor("SN-12345-03", 30);
        assertEquals(180, hub.getDataUsage());
    }

    @Test
    public void testIncreaseCommonAndNonExistentEighthSensorDataUsage() {
        SmartHub hub = new SmartHub("SN-12345", 100, 5);
        hub.registerDataUsage(50);
        assertThrows(IllegalArgumentException.class, () -> {
            hub.registerDataUsageOnConnectedSensor("SN-12345-08", 30);
        });
    }
}

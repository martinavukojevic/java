package org.example;

import org.eclipse.paho.client.mqttv3.MqttException;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeviceTest {
    private Device testDevice;

    @BeforeEach
    public void setUp() {
        testDevice = new Device("./src/main/resources/deserialization-test.json");

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            testDevice = objectMapper.readValue(new File(testDevice.getJsonPath()), Device.class);
        } catch (IOException e) {
            System.err.println("Error reading JSON: " + e.getMessage());
        }

        assertNotNull(testDevice, "Device should not be null after deserialization.");
        assertNotNull(testDevice.getSensors(), "Sensors list should not be null.");
        assertNotNull(testDevice.getAddress(), "Device address should not be null.");
        assertNotNull(testDevice.getTopic(), "Device topic should not be null.");
    }

    @Test
    public void testAddSensor() {
        assertEquals(2, testDevice.getSensors().size(), "Device should have 2 sensors.");
    }

    @Test
    public void testRunDevice() throws MqttException {
        testDevice.executeDevice();
    }
}

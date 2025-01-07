package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SensorTest {

    private Sensor testSensor;

    @BeforeEach
    void initializeSensor() {
        testSensor = new Sensor("TemperatureSensor", -10, 50, 0, 2, "Celsius");
    }

    @Test
    void testGenerateRandomValue() {
        testSensor.generateRandomValue();
        assertTrue(testSensor.getCurrentValue() >= testSensor.getMinRange() && testSensor.getCurrentValue() <= testSensor.getMaxRange(),
            "The generated value should be within the specified range.");
    }

    @Test
    void testInitialValue() {
        assertEquals(0, testSensor.getCurrentValue(), "Initial value of the sensor should be 0.");
    }

    @Test
    void testSetAndGetValue() {
        testSensor.setCurrentValue(25);
        assertEquals(25, testSensor.getCurrentValue(), "Sensor value should be set and retrieved correctly.");
    }
}

package org.example;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sensor {
    private String sensorName;
    private double minRange;
    private double maxRange;
    private double currentValue = 0;
    private int conversionFactor;
    private String measurementUnit;

    public void generateRandomValue() {
        this.currentValue = Math.round((Math.random() * (this.maxRange - this.minRange)) + this.minRange);
    }

    public String retrieveSensorData() {
        return "Sensor: " + sensorName 
             + " | Value: " + currentValue 
             + " | Factor: " + conversionFactor 
             + " | Unit: " + measurementUnit;
    }
}

package org.example;

public class Main {
    public static void main(String[] args) {
        String configPath = "src/main/resources/deserialization.json";
        Device configuredDevice = Deserialization.convertJsonToDevice(configPath);

        if (configuredDevice != null) {
            configuredDevice.executeDevice();
        } else {
            System.err.println("Device initialization failed");
        }
    }
}

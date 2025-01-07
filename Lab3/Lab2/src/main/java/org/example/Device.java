package org.example;

import lombok.*;
import org.eclipse.paho.client.mqttv3.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    private MqttClient mqttClient;
    private String deviceTopic;
    private String deviceAddress;
    private List<Sensor> sensors;
    private String jsonFilePath;

    
    public Device(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
    }

    
    public void runDevice() {
        try {
            mqttClient = new MqttClient(this.deviceAddress, this.deviceTopic);
        } catch (MqttException e) {
            System.err.println("Error connecting to MQTT: " + e.getMessage());
            return;
        }

        try {
            MqttConnectOptions connectionOptions = new MqttConnectOptions();
            mqttClient.connect(connectionOptions);
            
            int messageCounter = 1;
            for (Sensor sensor : sensors) {
                sensor.generateRandomValue();
                String sensorData = sensor.getSensorData();
                MqttMessage mqttMessage = new MqttMessage(sensorData.getBytes());
                mqttClient.publish(this.deviceTopic, mqttMessage);
                System.out.println(messageCounter + ". Message published.");
                messageCounter++;
            }

            mqttClient.disconnect();
            mqttClient.close();
        } catch (MqttException e) {
            System.err.println("Error during MQTT communication: " + e.getMessage());
        }
    }
}

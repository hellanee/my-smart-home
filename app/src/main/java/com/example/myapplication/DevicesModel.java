package com.example.myapplication;

public class DevicesModel {
    String device;
    int switch_state;
    public DevicesModel(String device, int state) {
        this.device = device;
        this.switch_state = state;
    }

    public String getDevice() {
        return device;
    }

    public boolean isSwitchOn() {
        return switch_state != 0;
    }
}

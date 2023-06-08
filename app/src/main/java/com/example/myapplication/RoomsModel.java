package com.example.myapplication;

public class RoomsModel {
    String room;
    String roomDevices;
    int image;
    int devicesCount;


    public RoomsModel(String room, String roomDevices, int image, int devicesCount) {
        this.room = room;
        this.roomDevices = roomDevices;
        this.image = image;
        this.devicesCount = devicesCount;
    }

    public String getRoom() {
        return room;
    }

    public String getRoomDevices() {
        return roomDevices;
    }

    public int getImage() {
        return image;
    }

    public int getDevicesCount() {
        return devicesCount;
    }
}

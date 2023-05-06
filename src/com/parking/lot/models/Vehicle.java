package com.parking.lot.models;

import com.parking.lot.enums.VehicleType;

public class Vehicle {
    private String number;
    private String color;
    private VehicleType vehicleType;

    public Vehicle(String number, String color, VehicleType vehicleType) {
        this.number = number;
        this.color = color;
        this.vehicleType = vehicleType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}

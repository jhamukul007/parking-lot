package com.parking.lot.models;

import java.util.LinkedList;
import java.util.List;

public class ParkingLot {
    private Integer id;
    private List<ParkingFloor> floor;
    private VehicleSlots slots;

    public ParkingLot(Integer id) {
        this.id = id;
        this.floor = new LinkedList<>();
        this.slots = new VehicleSlots();
    }

    public void addParkingFloor(ParkingFloor floor) {
        this.floor.add(floor);
    }

    public void removeParkingFloor(ParkingFloor floor) {
        this.floor.remove(floor);
    }

    public VehicleSlots getSlots() {
        return slots;
    }

    public Integer getId() {
        return id;
    }
}

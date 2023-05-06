package com.parking.lot.models;

public class CarSlots implements VehicleSlotDistribution {
    private SlotStrategy carSlots;

    public CarSlots() {
        this.carSlots = new SlotManager();
    }

    @Override
    public SlotStrategy getSlots() {
        return carSlots;
    }
}

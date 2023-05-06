package com.parking.lot.models;

public class BikeSlots implements VehicleSlotDistribution {
    private SlotStrategy bikeSlots;

    public BikeSlots() {
        this.bikeSlots = new SlotManager();
    }

    @Override
    public SlotStrategy getSlots() {
        return bikeSlots;
    }
}

package com.parking.lot.models;


public class TruckSlots implements VehicleSlotDistribution {
    private SlotStrategy truckSlots;

    public TruckSlots() {
        this.truckSlots = new SlotManager();
    }

    @Override
    public SlotStrategy getSlots() {
        return truckSlots;
    }
}

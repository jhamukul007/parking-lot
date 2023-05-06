package com.parking.lot.models;

import com.parking.lot.enums.VehicleType;

public class VehicleSlots {
    private BikeSlots bikeSlots;
    private CarSlots carSlots;
    private TruckSlots truckSlots;

    public VehicleSlots() {
        this.bikeSlots = new BikeSlots();
        this.carSlots = new CarSlots();
        this.truckSlots = new TruckSlots();
    }

    public SlotStrategy getParkingLotManager(VehicleType type) {
        VehicleSlotDistribution slotDistribution;
        switch (type) {
            case CAR:
                slotDistribution = carSlots;
                break;
            case BIKE:
                slotDistribution = bikeSlots;
                break;
            case TRUCK:
                slotDistribution = truckSlots;
                break;
            default:
                throw new IllegalArgumentException("VehicleType not supported " + type);
        }
        return slotDistribution.getSlots();
    }
}

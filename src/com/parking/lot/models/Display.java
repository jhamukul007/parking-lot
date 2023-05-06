package com.parking.lot.models;

import com.parking.lot.enums.VehicleType;

import java.util.List;
import java.util.Map;

public class Display {
    private final ParkingLotManager parkingLotManager;

    public Display(ParkingLotManager parkingLotManager) {
        this.parkingLotManager = parkingLotManager;
    }

    void freeSlotsCount(VehicleType type) {
        //  SlotsStrategyManager.getStrategy(type).
    }

    public void freeSlotsPerFloor(Integer parkingLotId, VehicleType type) {
        ParkingLot parkingLot = parkingLotManager.getParkingLotById(parkingLotId);
        Map<Integer, List<ParkingSlots>> slots = parkingLot.getSlots().getParkingLotManager(type).getAvailableParkingSlotsByFloor();
        System.out.println("Free Parking slot of " + type);
        slots.forEach((key, values) -> {
            System.out.println();
            System.out.print("Floor : " + key + " Slots : [");
            values.forEach(value -> {
                System.out.print(value.getSlotNo() + " ");
            });
            System.out.print("]");
        });
        System.out.println();
    }

    public void occupiedSlotsPerFloor(Integer parkingLotId, VehicleType type) {
        ParkingLot parkingLot = parkingLotManager.getParkingLotById(parkingLotId);
        Map<Integer, List<ParkingSlots>> slots = parkingLot.getSlots().getParkingLotManager(type).getUnAvailableParkingSlotsByFloor();
        System.out.println("Occupied Parking slot of " + type);
        slots.forEach((key, values) -> {
            System.out.println();
            System.out.print("Floor : " + key + " Slots : [");
            values.forEach(value -> {
                System.out.print(value.getSlotNo() + " ");
            });
            System.out.print("]");
        });
        System.out.println();
    }
}

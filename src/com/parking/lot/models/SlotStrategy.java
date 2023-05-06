package com.parking.lot.models;

import com.parking.lot.enums.VehicleType;

import java.util.List;
import java.util.Map;

public interface SlotStrategy {
    ParkingSlots getAvailableSlot();

    void markFreeSlot(ParkingSlots slot);

    Map<Integer, List<ParkingSlots>> getAvailableParkingSlotsByFloor();

    Map<Integer, List<ParkingSlots>> getUnAvailableParkingSlotsByFloor();

    void addSlot(ParkingSlots slot);
}

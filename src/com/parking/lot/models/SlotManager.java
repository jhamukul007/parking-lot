package com.parking.lot.models;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SlotManager implements SlotStrategy {

    private PriorityQueue<ParkingSlots> availableSlots;
    private Map<Integer, List<ParkingSlots>> availableSlotsListOnFloor;
    private Map<Integer, List<ParkingSlots>> bookedSlotsOnFloor;

    public SlotManager() {
        this.availableSlots = new PriorityQueue<>(nearSlots);
        this.availableSlotsListOnFloor = new HashMap<>();
        this.bookedSlotsOnFloor = new HashMap<>();
    }

    @Override
    public ParkingSlots getAvailableSlot() {
        ParkingSlots slot;
        if (availableSlots.isEmpty())
            return null;
        synchronized (this) {
            slot = availableSlots.poll();
            List<ParkingSlots> availSlots = availableSlotsListOnFloor.get(slot.getFloorNo());
            if (availSlots != null)
                availSlots.remove(slot);
            availableSlotsListOnFloor.put(slot.getFloorNo(), availSlots);
            List<ParkingSlots> bookedSlots = bookedSlotsOnFloor.getOrDefault(slot.getFloorNo(), new LinkedList<>());
            bookedSlots.add(slot);
            bookedSlotsOnFloor.put(slot.getFloorNo(), bookedSlots);
        }
        return slot;
    }

    @Override
    public void markFreeSlot(ParkingSlots slot) {
        synchronized (this) {
            List<ParkingSlots> bookedSlots = bookedSlotsOnFloor.get(slot.getFloorNo());
            if (bookedSlots != null) {
                bookedSlots.remove(slot);
            }
            bookedSlotsOnFloor.put(slot.getFloorNo(), bookedSlots);
            List<ParkingSlots> availSlots = availableSlotsListOnFloor.getOrDefault(slot.getFloorNo(), new LinkedList<>());
            availSlots.add(slot);
            availableSlotsListOnFloor.put(slot.getFloorNo(), availSlots);
            availableSlots.offer(slot);
        }
    }

    @Override
    public Map<Integer, List<ParkingSlots>> getAvailableParkingSlotsByFloor() {
        return availableSlotsListOnFloor;
    }

    @Override
    public Map<Integer, List<ParkingSlots>> getUnAvailableParkingSlotsByFloor() {
        return bookedSlotsOnFloor;
    }

    @Override
    public void addSlot(ParkingSlots parkingSlots) {
        availableSlots.add(parkingSlots);
        List<ParkingSlots> slots = availableSlotsListOnFloor.getOrDefault(parkingSlots.getFloorNo(), new LinkedList<>());
        slots.add(parkingSlots);
        availableSlotsListOnFloor.put(parkingSlots.getFloorNo(), slots);
    }

    Comparator<ParkingSlots> nearSlots = (o1, o2) -> {
        if (o1.getFloorNo() == o2.getFloorNo())
            return o1.getSlotNo() - o2.getSlotNo();
        return o1.getFloorNo() - o2.getFloorNo();
    };
}

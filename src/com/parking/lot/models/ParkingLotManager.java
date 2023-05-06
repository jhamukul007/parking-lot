package com.parking.lot.models;

import com.parking.lot.enums.VehicleType;
import com.parking.lot.exceptions.SlotNotAvailableException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotManager {
    private Map<String, Ticket> currentTicketMap;
    private Map<Integer, ParkingLot> parkingLots;

    public ParkingLotManager() {
        this.currentTicketMap = new HashMap<>();
        this.parkingLots = new HashMap<>();
    }

    public Ticket parkVehicle(Integer parkingLotId, VehicleType vehicleType, String regNo, String color) {
        Vehicle vehicle = new Vehicle(regNo, color, vehicleType);
        ParkingLot parkingLot = getParkingLotById(parkingLotId);
        if (parkingLot == null)
            return null;

        ParkingSlots availableSlot = parkingLot.getSlots().getParkingLotManager(vehicleType).getAvailableSlot();
        if (availableSlot == null)
            throw new SlotNotAvailableException("Slot not available for vehicleType " + vehicleType);
        String ticketId = availableSlot.getSlotNo() + " " + availableSlot.getFloorNo();
        Ticket ticket = new Ticket(ticketId, vehicle, availableSlot, parkingLot.getId());
        currentTicketMap.put(ticket.getTicketId(), ticket);
        System.out.println("Park " + vehicleType + " with number " + regNo + " at floor " + availableSlot.getFloorNo() + " slot " + availableSlot.getSlotNo());
        return ticket;
    }

    public void unparkVehicle(String ticketId) {
        Ticket ticket = currentTicketMap.get(ticketId);
        ParkingLot parkingLot = getParkingLotById(ticket.getParkingId());
        if (ticket == null) return;
        parkingLot.getSlots().getParkingLotManager(ticket.getVehicle().getVehicleType()).markFreeSlot(ticket.getSlot());
        currentTicketMap.remove(ticket);
        System.out.println("Unparked vehicleType " + ticket.getVehicle().getVehicleType() + " with number " + ticket.getVehicle().getNumber());
    }

    public void createParkingLot(Integer parkingLotId, Integer noOfFloor, Integer noOfSlots) {
        ParkingLot parkingLot = new ParkingLot(parkingLotId);

        for (int i = 0; i < noOfFloor; i++) {
            ParkingFloor parkingFloor = new ParkingFloor(i + 1);
            for (int j = 0; j < noOfSlots; j++) {
                ParkingSlots slot = new ParkingSlots(i + 1, j + 1);
                VehicleType vehicleType;
                if (j == 0) {
                    vehicleType = VehicleType.TRUCK;
                } else if (j == 1 || j == 2)
                    vehicleType = VehicleType.BIKE;
                else
                    vehicleType = VehicleType.CAR;

                slot.setVehicleType(vehicleType);
                parkingLot.getSlots().getParkingLotManager(vehicleType).addSlot(slot);
            }
            parkingLot.addParkingFloor(parkingFloor);
        }
        parkingLots.put(parkingLotId, parkingLot);
    }

    public ParkingLot getParkingLotById(Integer id) {
        return parkingLots.get(id);
    }
}

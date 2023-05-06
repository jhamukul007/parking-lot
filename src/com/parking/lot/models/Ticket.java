package com.parking.lot.models;

import java.util.Objects;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private ParkingSlots slot;
    private Integer parkingId;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSlots slot, Integer parkingId) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.slot = slot;
        this.parkingId = parkingId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSlots getSlot() {
        return slot;
    }

    public void setSlot(ParkingSlots slot) {
        this.slot = slot;
    }

    public Integer getParkingId() {
        return parkingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(ticketId, ticket.ticketId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId);
    }
}

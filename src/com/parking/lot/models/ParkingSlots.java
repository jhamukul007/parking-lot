package com.parking.lot.models;

import com.parking.lot.enums.VehicleType;

import java.util.Objects;

public class ParkingSlots {
    private Integer floorNo;
    private Integer slotNo;
    private VehicleType vehicleType;

    public ParkingSlots(Integer floorNo, Integer slotNo) {
        this.floorNo = floorNo;
        this.slotNo = slotNo;
    }

    public Integer getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(Integer floorNo) {
        this.floorNo = floorNo;
    }

    public Integer getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(Integer slotNo) {
        this.slotNo = slotNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingSlots that = (ParkingSlots) o;
        return Objects.equals(floorNo, that.floorNo) && Objects.equals(slotNo, that.slotNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(floorNo, slotNo);
    }

    @Override
    public String toString() {
        return "ParkingSlots{" +
                "floorNo=" + floorNo +
                ", slotNo=" + slotNo +
                ", vehicleType=" + vehicleType +
                '}';
    }
}

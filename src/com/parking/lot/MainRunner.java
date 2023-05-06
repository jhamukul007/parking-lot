package com.parking.lot;

import com.parking.lot.enums.VehicleType;
import com.parking.lot.models.Display;
import com.parking.lot.models.ParkingLotManager;
import com.parking.lot.models.Ticket;

public class MainRunner {

    public static void main(String[] args) {
        ParkingLotManager parkingLotManager = new ParkingLotManager();
        parkingLotManager.createParkingLot(1, 2, 10);
        Display display = new Display(parkingLotManager);
        display.freeSlotsPerFloor(1, VehicleType.TRUCK);
        System.out.println("*****************");
        display.freeSlotsPerFloor(1, VehicleType.BIKE);

        System.out.println("*****************");
        display.freeSlotsPerFloor(1, VehicleType.CAR);

        Ticket ticket1 = parkingLotManager.parkVehicle(1, VehicleType.TRUCK, "KA031511", "Black");

        System.out.println("*****************");
        display.freeSlotsPerFloor(1, VehicleType.TRUCK);

        System.out.println("*****************");
        display.occupiedSlotsPerFloor(1, VehicleType.TRUCK);

        parkingLotManager.parkVehicle(1, VehicleType.TRUCK, "KL021690", "Red");

        parkingLotManager.unparkVehicle(ticket1.getTicketId());

        parkingLotManager.parkVehicle(1, VehicleType.TRUCK, "DL031256", "Blue");

        parkingLotManager.parkVehicle(1, VehicleType.CAR, "KA08099", "White");

        Ticket Mat = parkingLotManager.parkVehicle(1, VehicleType.CAR, "MA89099", "White");
        parkingLotManager.parkVehicle(1, VehicleType.CAR, "KA898989", "White");

        System.out.println("*****************");
        display.freeSlotsPerFloor(1, VehicleType.CAR);

        System.out.println("*****************");
        display.occupiedSlotsPerFloor(1, VehicleType.CAR);

        parkingLotManager.unparkVehicle(Mat.getTicketId());

        System.out.println("*****************");
        display.freeSlotsPerFloor(1, VehicleType.CAR);

        System.out.println("*****************");
        display.occupiedSlotsPerFloor(1, VehicleType.CAR);

        parkingLotManager.parkVehicle(1, VehicleType.CAR, "KA00000", "Green");

        System.out.println("*****************");
        display.freeSlotsPerFloor(1, VehicleType.CAR);

        System.out.println("*****************");
        display.occupiedSlotsPerFloor(1, VehicleType.CAR);

    }
}

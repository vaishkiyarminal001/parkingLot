package com.app.main;

import com.app.model.Vehicle;
import com.app.model.VehicleType;
import com.app.service.CostStrategy;
import com.app.service.CostStrategyImpl;
import com.app.service.ParkingStrategy;
import com.app.service.ParkingStrategyImpl;

public class Main {
	public static void main(String[] args) {

		// create an object for calculating parking costs
		CostStrategy costStrategy = new CostStrategyImpl();

		// create an object for managing parking with cost strategy
		ParkingStrategy parkingStrategy = new ParkingStrategyImpl(costStrategy);
		//initialize parking strategy with initial capacity, slots for each vehicletype
		parkingStrategy.init(2, 5, VehicleType.CAR);

		// Adding the details like number, color, type and duration.
		parkingStrategy.addVehicle(new Vehicle("BH02-9684", "Black", VehicleType.CAR, 2));
		parkingStrategy.addVehicle(new Vehicle("BH05-9874", "White", VehicleType.TRUCK, 1));
		parkingStrategy.addVehicle(new Vehicle("BH09-6325", "Red", VehicleType.BIKE, 5));
		parkingStrategy.addVehicle(new Vehicle("BH07-7856", "Z-Black", VehicleType.SPORTS_CAR, 1));
		parkingStrategy.addVehicle(new Vehicle("MH08-9642", "White", VehicleType.VAN,10));
		
		System.out.println("Add");
		System.out.println();

		// checking the availiability according to the vehicle type
		parkingStrategy.checkAvailability(1, VehicleType.CAR);
		parkingStrategy.checkAvailability(1, VehicleType.TRUCK);
		parkingStrategy.checkAvailability(1, VehicleType.BIKE);
		parkingStrategy.checkAvailability(1, VehicleType.SPORTS_CAR);
		
		System.out.println("Check");
		System.out.println();
		

		// remove the vehicle accoring to the registration number
//		parkingStrategy.removeVehicle("BH02-9684");
//		parkingStrategy.removeVehicle("BH05-9874");
//		parkingStrategy.removeVehicle("BH09-6325");
//		parkingStrategy.removeVehicle("BH07-7856");
		
//		System.out.println("Remove");
		System.out.println();

		//calculating parking fee for different vehicle types and duration
		double parkingFeeCar = parkingStrategy.calculateParkingFee(3, VehicleType.CAR);
		System.out.println("Parking fee for 3 hours: " + parkingFeeCar);
		
		double parkingFeeTruck = parkingStrategy.calculateParkingFee(10, VehicleType.TRUCK);
		System.out.println("Parking fee for 10 hours: " + parkingFeeTruck);
		
		double parkingFeeBike = parkingStrategy.calculateParkingFee(1, VehicleType.BIKE);
		System.out.println("Parking fee for 1 hours: " + parkingFeeBike);
		
		double parkingFeeSports = parkingStrategy.calculateParkingFee(2, VehicleType.SPORTS_CAR);
		System.out.println("Parking fee for 2 hours: " + parkingFeeSports);

	}

}

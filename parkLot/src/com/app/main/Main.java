package com.app.main;

import com.app.model.Vehicle;
import com.app.model.VehicleType;
import com.app.service.CostStrategy;
import com.app.service.CostStrategyImpl;
import com.app.service.ParkingStrategy;
import com.app.service.ParkingStrategyImpl;

public class Main {
	public static void main(String[] args) {

		CostStrategy costStrategy = new CostStrategyImpl();

		ParkingStrategy parkingStrategy = new ParkingStrategyImpl(costStrategy);
		parkingStrategy.init(2, 5, VehicleType.CAR);

		parkingStrategy.addVehicle(new Vehicle("BH02-9684", "Black", VehicleType.CAR, 2));
		parkingStrategy.addVehicle(new Vehicle("BH05-9874", "White", VehicleType.TRUCK, 1));
		parkingStrategy.addVehicle(new Vehicle("BH09-6325", "Red", VehicleType.BIKE, 5));
		parkingStrategy.addVehicle(new Vehicle("BH07-7856", "Z-Black", VehicleType.SPORTS_CAR, 1));

		parkingStrategy.checkAvailability(1, VehicleType.CAR);
		parkingStrategy.checkAvailability(1, VehicleType.TRUCK);
		parkingStrategy.checkAvailability(1, VehicleType.BIKE);
		parkingStrategy.checkAvailability(1, VehicleType.SPORTS_CAR);
		

		parkingStrategy.removeVehicle("BH02-9684");
		parkingStrategy.removeVehicle("BH05-9874");
		parkingStrategy.removeVehicle("BH09-6325");
		parkingStrategy.removeVehicle("BH07-7856");

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

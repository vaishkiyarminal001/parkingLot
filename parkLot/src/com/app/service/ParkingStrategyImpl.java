package com.app.service;

import com.app.model.Vehicle;
import com.app.model.VehicleType;

public class ParkingStrategyImpl implements ParkingStrategy {
	private ParkingLot parkingLot;
	private CostStrategy costStrategy;

	public ParkingStrategyImpl(CostStrategy costStrategy) {
		this.costStrategy = costStrategy;
	}

	@Override
	public void init(int totalFloors, int spacesPerFloor, VehicleType type) {
		parkingLot = new ParkingLot(totalFloors, spacesPerFloor, type);
	}

	@Override
	public void addVehicle(Vehicle vehicle) {
		if (parkingLot != null) {
			parkingLot.addVehicle(vehicle);
		} else {
			System.out.println("Parking lot not initialized.");
		}
	}

	@Override
	public void removeVehicle(String registrationNumber) {
		if (parkingLot != null) {
			parkingLot.removeVehicle(registrationNumber);
			
			 System.out.println("Vehicle with registration number " + registrationNumber + " has been removed.");
		} else {
			System.out.println("Parking lot not initialized.");
		}
	}

	@Override
	public boolean checkAvailability(int floorNumber, VehicleType type) {
		if (parkingLot != null) {
		boolean t = parkingLot.checkAvailability(floorNumber, type);
			  System.out.println("Availability on Floor "+ floorNumber +  " for Car: " + t);
			  return t;
		} else {
			System.out.println("Parking lot not initialized.");
			return false;
		}
	}

	@Override
	public double calculateParkingFee(int durationInHours,VehicleType type) {
		
		return costStrategy.calculateParkingFee(type, durationInHours);
	}

	
}

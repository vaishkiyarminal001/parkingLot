package com.app.service;

import com.app.exception.NotFoundException;
import com.app.exception.SomethingWentWrong;
import com.app.model.Vehicle;
import com.app.model.VehicleType;


//Implementation of the ParkingStrategy interface and managing all the operations

public class ParkingStrategyImpl implements ParkingStrategy {
	private ParkingLot parkingLot;
	private CostStrategy costStrategy;

	
	
//Created Constructor for parkingStrategy and the costStrategy is used for calculating the fee
	public ParkingStrategyImpl(CostStrategy costStrategy) {
		this.costStrategy = costStrategy;
	}

	
	
//In this operation I have initalizes the specific parameters like totalFloors(total number of floors)
//spacePerFloor(Number of parking space per floor) and type(which type of vehicle is allowed in the lot) and 
//SomethingWentWrong is used, if an error occures during init.
//NotFoundException if the requested floor or vehicle type is not found.	
	
	@Override
	public void init(int totalFloors, int spacesPerFloor, VehicleType type) throws SomethingWentWrong, NotFoundException {
		parkingLot = new ParkingLot(totalFloors, spacesPerFloor, type);
	}
	
//In addVehicle operation I passed parameters as vehicle(this is used for addeding the vehicle)
//SomethingWentWrong is used, if an error occures during the adding vehicle.

	@Override
	public void addVehicle(Vehicle vehicle) throws SomethingWentWrong {
		if (parkingLot != null) {
			parkingLot.addVehicle(vehicle);
		} else {
			System.out.println("Parking lot not initialized.");
		}
	}
	

//In removeVehicle operation I passed parameters as registrationNumber(this is used for removing the vehicle through registration number)
//SomethingWentWrong is used, if an error occures during initialization

	@Override
	public void removeVehicle(String registrationNumber) throws SomethingWentWrong {
		if (parkingLot != null) {
			parkingLot.removeVehicle(registrationNumber);
			
			 System.out.println("Vehicle with registration number " + registrationNumber + " has been removed.");
		} else {
			System.out.println("Parking lot not initialized.");
		}
	}
	
//In checkAvailability operation two parameters passed one for floorNumber(used to check the availability) another one is for type(check the type of vehicle for the availability for)
//and it will return true if parking space are available, otherwise false
//SomethingWentWrong and NotFoundExceptionis used when an error occurs during availability check.

	@Override
	public boolean checkAvailability(int floorNumber, VehicleType type) throws SomethingWentWrong, NotFoundException {
		if (parkingLot != null) {
		boolean t = parkingLot.checkAvailability(floorNumber, type);
			  System.out.println("Availability on Floor "+ floorNumber +  " for Car: " + t);
			  return t;
		} else {
			System.out.println("Parking lot not initialized.");
			return false;
		}
	}
	
//In calculateParkingFee operation two parameters passed one for durationInHours(used to check the duration of parking in hour) 
//another one is for type(check the type of vehicle so that accordingly it will calculate the fee)
//and it will return the calculated fee
//SomethingWentWrong and NotFoundException is used when an error occurs during calculateParkingFee.	

	@Override
	public double calculateParkingFee(int durationInHours,VehicleType type) throws SomethingWentWrong, NotFoundException{
		
		return costStrategy.calculateParkingFee(type, durationInHours);
	}

	
}

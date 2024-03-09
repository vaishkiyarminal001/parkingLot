package com.app.service;

import com.app.model.Vehicle;
import com.app.model.VehicleType;

public interface ParkingStrategy {

	void init(int totalFloors, int spacesPerFloor, VehicleType type);

	void addVehicle(Vehicle vehicle);

	void removeVehicle(String registrationNumber);

	boolean checkAvailability(int floorNumber, VehicleType type);

	double calculateParkingFee(int durationInHours, VehicleType type);

}

package com.app.service;

import java.util.List;

import com.app.model.Vehicle;
import com.app.model.VehicleType;

public interface ParkingLotService {
	
	List<Floor> initializeFloors(int totalFloors, int spacesPerFloor, VehicleType type);
	boolean checkAvailability(int floorNumber, VehicleType type);
	void addVehicle(Vehicle vehicle);
	void removeVehicle(String registrationNumber);

}

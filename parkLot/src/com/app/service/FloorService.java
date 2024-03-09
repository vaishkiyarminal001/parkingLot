package com.app.service;

import java.util.List;

import com.app.model.Vehicle;
import com.app.model.VehicleSpace;
import com.app.model.VehicleType;

public interface FloorService {
   
	List<VehicleSpace> initializeVehicleSpaces(int totalSpaces, VehicleType type);
	boolean hasAvailableSpace(VehicleType type);
	VehicleSpace parkVehicle(Vehicle vehicle);
	void removeVehicle(String registrationNumber);
	
}

package com.app.service;

import java.util.List;

import com.app.exception.NotFoundException;
import com.app.exception.SomethingWentWrong;
import com.app.model.Vehicle;
import com.app.model.VehicleSpace;
import com.app.model.VehicleType;

public interface FloorService {
   
	List<VehicleSpace> initializeVehicleSpaces(int totalSpaces, VehicleType type) throws SomethingWentWrong, NotFoundException;
	boolean hasAvailableSpace(VehicleType type) throws SomethingWentWrong;
	VehicleSpace parkVehicle(Vehicle vehicle) throws SomethingWentWrong;
	void removeVehicle(String registrationNumber) throws SomethingWentWrong;
	
}

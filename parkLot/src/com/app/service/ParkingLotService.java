package com.app.service;

import java.util.List;

import com.app.exception.NotFoundException;
import com.app.exception.SomethingWentWrong;
import com.app.model.Vehicle;
import com.app.model.VehicleType;

public interface ParkingLotService {
	
	List<Floor> initializeFloors(int totalFloors, int spacesPerFloor, VehicleType type) throws SomethingWentWrong, NotFoundException;
	boolean checkAvailability(int floorNumber, VehicleType type)throws SomethingWentWrong, NotFoundException;
	void addVehicle(Vehicle vehicle) throws SomethingWentWrong;
	void removeVehicle(String registrationNumber) throws SomethingWentWrong;

}

package com.app.service;

import com.app.exception.NotFoundException;
import com.app.exception.SomethingWentWrong;
import com.app.model.Vehicle;
import com.app.model.VehicleType;

public interface ParkingStrategy {

	void init(int totalFloors, int spacesPerFloor, VehicleType type) throws SomethingWentWrong, NotFoundException;

	void addVehicle(Vehicle vehicle) throws SomethingWentWrong;

	void removeVehicle(String registrationNumber) throws SomethingWentWrong;

	boolean checkAvailability(int floorNumber, VehicleType type) throws SomethingWentWrong, NotFoundException;

	double calculateParkingFee(int durationInHours, VehicleType type) throws SomethingWentWrong, NotFoundException;

}

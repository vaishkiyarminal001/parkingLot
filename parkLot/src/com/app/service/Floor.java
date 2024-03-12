package com.app.service;

import java.util.ArrayList;
import java.util.List;

import com.app.exception.NotFoundException;
import com.app.exception.SomethingWentWrong;
import com.app.model.Vehicle;
import com.app.model.VehicleSpace;
import com.app.model.VehicleType;

public class Floor implements FloorService {
	private int floorNumber;
	private List<VehicleSpace> vehicleSpaces;
	
	
	// Getter setter

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public List<VehicleSpace> getVehicleSpaces() {
		return vehicleSpaces;
	}

	public void setVehicleSpaces(List<VehicleSpace> vehicleSpaces) {
		this.vehicleSpaces = vehicleSpaces;
	}
	
	// constructor

	public Floor(int floorNumber, int totalSpaces, VehicleType type) {
		this.floorNumber = floorNumber;
		this.vehicleSpaces = initializeVehicleSpaces(totalSpaces, type);
	}
	
	
	
	//In this operation I have initalizes the specific parameters like totalspace(check the total available space)
	//type(check the vehivle type for the space)
	//SomethingWentWrong and NotFoundException is used, if an error occures during initialization.
	//NotFoundException NotFoundException if the requested floor or vehicle type is not found.	

	@Override
	public List<VehicleSpace> initializeVehicleSpaces(int totalSpaces, VehicleType type) throws SomethingWentWrong, NotFoundException{
		List<VehicleSpace> spaces = new ArrayList<>();
		for (int i = 1; i <= totalSpaces; i++) {
			spaces.add(new VehicleSpace(i, type));
		}
		return spaces;
	}

	
	//In this operation hasAvailableSpace I have initalizes the specific parameters type(check the vehicle type for the space)
	//SomethingWentWrong and NotFoundException is used, if an error occures during the space available
	//NotFoundExceptionif the requested floor or vehicle type is not found.	
	//and in this method i used stream API java 8 feature
	
	@Override
	public boolean hasAvailableSpace(VehicleType type) throws SomethingWentWrong{
		return vehicleSpaces.stream().anyMatch(space -> space.isAvailable() && space.getType() == type);
	}
	
	
	//In this operation parkVehicle I have initalizes the specific parameters vehicle(check the vehicle type for parking and for the space)
	//SomethingWentWrong is used, if an error occures during the parking vehicle
	//NotFoundException if the requested floor or vehicle type is not found.	

	@Override
	public VehicleSpace parkVehicle(Vehicle vehicle)throws SomethingWentWrong {
		for (VehicleSpace space : vehicleSpaces) {
			if (space.isAvailable() && space.getType() == vehicle.getType()) {
				space.occupy(vehicle);
				return space;
			}
		}
		return null;
	}
	
//removeVechile is used to remove the vehicle from the floor based on its registration number
//registrationNumber parameter is passed so that it can be removed from the registration number
//SomethingWentWrong and NotFoundException is used, if an error occures during the removel vehicl

	@Override
	public void removeVehicle(String registrationNumber)throws SomethingWentWrong {
		for (VehicleSpace space : vehicleSpaces) {
			if (!space.isAvailable() && space.getVehicle().getRegistrationNumber().equals(registrationNumber)) {
				space.vacate();
				break;
			}
		}
	}
}

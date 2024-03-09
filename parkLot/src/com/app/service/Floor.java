package com.app.service;

import java.util.ArrayList;
import java.util.List;

import com.app.model.Vehicle;
import com.app.model.VehicleSpace;
import com.app.model.VehicleType;

public class Floor implements FloorService {
	private int floorNumber;
	private List<VehicleSpace> vehicleSpaces;
	
	

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

	public Floor(int floorNumber, int totalSpaces, VehicleType type) {
		this.floorNumber = floorNumber;
		this.vehicleSpaces = initializeVehicleSpaces(totalSpaces, type);
	}

	@Override
	public List<VehicleSpace> initializeVehicleSpaces(int totalSpaces, VehicleType type) {
		List<VehicleSpace> spaces = new ArrayList<>();
		for (int i = 1; i <= totalSpaces; i++) {
			spaces.add(new VehicleSpace(i, type));
		}
		return spaces;
	}

	@Override
	public boolean hasAvailableSpace(VehicleType type) {
		return vehicleSpaces.stream().anyMatch(space -> space.isAvailable() && space.getType() == type);
	}

	@Override
	public VehicleSpace parkVehicle(Vehicle vehicle) {
		for (VehicleSpace space : vehicleSpaces) {
			if (space.isAvailable() && space.getType() == vehicle.getType()) {
				space.occupy(vehicle);
				return space;
			}
		}
		return null;
	}

	@Override
	public void removeVehicle(String registrationNumber) {
		for (VehicleSpace space : vehicleSpaces) {
			if (!space.isAvailable() && space.getVehicle().getRegistrationNumber().equals(registrationNumber)) {
				space.vacate();
				break;
			}
		}
	}
}

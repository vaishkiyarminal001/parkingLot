package com.app.service;

import com.app.model.VehicleType;

public interface CostStrategy {

	
	 double calculateParkingFee(VehicleType type, int durationInHours);
}

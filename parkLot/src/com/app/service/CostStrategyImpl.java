package com.app.service;

import com.app.exception.NotFoundException;
import com.app.exception.SomethingWentWrong;
import com.app.model.VehicleType;

public class CostStrategyImpl implements CostStrategy {

	
//This is costStrategy interface implementation and calculateParkingFee operation is used for calculating the parking fee
//SomethingWentWrong is used when an error occurs during the calculation of the parking fee.
//NotFoundException if the requested floor or vehicle type is not found.	
	@Override
	public double calculateParkingFee(VehicleType type, int durationInHours) throws SomethingWentWrong, NotFoundException{
		// It will Calculate the parking fee based on the type of vehicle
		switch (type) {
		
		case BIKE:
			// Assuming parking fee for a bike is 10rs per hour
			return durationInHours * 10;
			
		case CAR:
			// Assuming parking fee for a car is 20rs per hour
			return durationInHours * 20;
		case TRUCK:
			
			// Assuming parking fee for a truck is 30rs per hour
			return durationInHours * 30;
			
		default:
			// If the vehicle type is not recognized, return 0.0
			return 0.0;
		}
	}
	
}
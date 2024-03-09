package com.app.service;

import com.app.model.VehicleType;

public class CostStrategyImpl implements CostStrategy {

	@Override
	public double calculateParkingFee(VehicleType type, int durationInHours) {
		switch (type) {
		case BIKE:
			return durationInHours * 10;
		case CAR:
			return durationInHours * 20;
		case TRUCK:
			return durationInHours * 30;
		default:
			return 0.0;
		}
	}
}
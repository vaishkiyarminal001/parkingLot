package com.app.service;

import com.app.exception.NotFoundException;
import com.app.exception.SomethingWentWrong;
import com.app.model.VehicleType;

public interface CostStrategy {

	 double calculateParkingFee(VehicleType type, int durationInHours) throws SomethingWentWrong, NotFoundException;
}

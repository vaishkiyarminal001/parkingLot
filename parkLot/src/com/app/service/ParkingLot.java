package com.app.service;

import java.util.ArrayList;
import java.util.List;

import com.app.exception.NotFoundException;
import com.app.exception.SomethingWentWrong;
import com.app.model.Vehicle;
import com.app.model.VehicleType;

public class ParkingLot implements ParkingLotService {
    private List<Floor> floors;

    
   // constructor
    
    public ParkingLot(int totalFloors, int spacesPerFloor, VehicleType type) {
        this.floors = initializeFloors(totalFloors, spacesPerFloor, type);
    }
    
  //initializeFloors operation is used for checkking the availabe floore space according to the vechicle type for parking(add) the vehicle
  //SomethingWentWrong is used when an error occurs during the initializing the floor.
  //NotFoundException NotFoundException if the requested floor or vehicle type is not found.	
  	

    @Override
    public List<Floor> initializeFloors(int totalFloors, int spacesPerFloor, VehicleType type)throws SomethingWentWrong, NotFoundException {
        List<Floor> init = new ArrayList<>();
        for (int floorNumber = 1; floorNumber <= totalFloors; floorNumber++) {
            init.add(new Floor(floorNumber, spacesPerFloor, type));
        }
        return init;
    }
    
//checkAvailability operation is used for checking the availibility of parking space for a specific vehicle type on a given floore
//parameters is used for floorNumber(The number of the floor to check) type(type of vehicle to check availability for.)
//SomethingWentWrong  is used when an error occurs during the checking.
//NotFoundException NotFoundException if the requested floor or vehicle type is not found.	
    

    @Override
    public boolean checkAvailability(int floorNumber, VehicleType type)throws SomethingWentWrong, NotFoundException {
        if (floorNumber >= 1 && floorNumber <= floors.size()) {
            Floor floor = floors.get(floorNumber - 1);
            return floor.hasAvailableSpace(type);
        }
        return false;
    }
    
    
    
    
  //addVehicle operation is used for Adds a vehicle to the parking lot by parking it on an available space.
  //parameters is used for vehicle(The vehicle to be parked.)
  //SomethingWentWrong  is used when an error occurs during the add vehicle process.
   

    @Override
    public void addVehicle(Vehicle vehicle)throws SomethingWentWrong{
        for (Floor floor : floors) {
            if (floor.hasAvailableSpace(vehicle.getType())) {
                floor.parkVehicle(vehicle);
                return;
            }
        }
        System.out.println("Parking is full for type " + vehicle.getType());
    }
    
    
  //removeVehicle operation is used for Removes a vehicle from the parking lot by finding and freeing up its parked space
  //parameters is used for registrationNumber(The registration number of the vehicle to be removed.)
  //SomethingWentWrong  is used when an error occurs during the removel process.

    @Override
    public void removeVehicle(String registrationNumber)throws SomethingWentWrong{
        for (Floor floor : floors) {
        	 floor.removeVehicle(registrationNumber);
        
        	 }
           
        }
    }


# Parking Lot

This Java program implements a car parking system with configurable cost strategy.

## Overview

The parking system is designed to manage parking spaces for different types of vehicles in a multi-floor parking lot. It supports functionalities such as adding vehicles, removing vehicles, checking availability of parking spaces, and calculating parking fees based on a configurable cost strategy.

## Functionality

1. **Initialization:**
   - Initialize the parking lot by creating an instance of `ParkingLot` with the desired number of floors and vehicle spaces per floor.

2. **Adding Vehicles:**
   - Use the `addVehicle` method of the `ParkingLot` class to add vehicles to the parking lot.
   - Provide the vehicle details such as registration number and type.

3. **Removing Vehicles:**
   - Use the `removeVehicle` method of the `ParkingLot` class to remove a vehicle from the parking lot.
   - Provide the registration number of the vehicle to be removed.

4. **Checking Availability:**
   - Use the `checkAvailability` method of the `ParkingLot` class to check the availability of vehicle spaces on a specific floor for a given vehicle type.
   - Provide the floor number and vehicle type to check availability.

5. **Cost Calculation:**
   - The cost strategy for parking is implemented in the `FlatCostStrategy` class.
   - The cost is calculated based on the duration of parking and the type of vehicle.

## Design and Build by Minal Kumari

package com.app.model;

public class VehicleSpace {
    private int spaceNumber;
    private boolean availability;
    private VehicleType type;
    private Vehicle vehicle;

    public VehicleSpace(int spaceNumber, VehicleType type) {
        this.spaceNumber = spaceNumber;
        this.type = type;
        this.availability = true;
        this.vehicle = null;
    }

    public int getSpaceNumber() {
        return spaceNumber;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void occupy(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.availability = false;
    }

    public void vacate() {
        this.vehicle = null;
        this.availability = true;
    }

    public VehicleType getType() {
        return type;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}

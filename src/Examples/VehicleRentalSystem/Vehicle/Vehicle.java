package Examples.VehicleRentalSystem.Vehicle;

import Examples.VehicleRentalSystem.Vehicle.Enums.VehicleStatus;
import Examples.VehicleRentalSystem.Vehicle.Enums.VehicleType;

public class Vehicle {
    // identifier
    int id;
    String licensePlate;

    // basic details
    String manufacturer;
    String model;
    int seatCapacity;
    VehicleType vehicleType;

    // rental cost
    double dailyRentalCost;
    VehicleStatus status;

    // good to have info
    double kmDriven;
    double horsePower;

    public Vehicle(int id, String licensePlate, String manufacturer, String model, int seatCapacity,
            VehicleType vehicleType, double dailyRentalCost, double kmDriven, double horsePower) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.manufacturer = manufacturer;
        this.model = model;
        this.seatCapacity = seatCapacity;
        this.vehicleType = vehicleType;
        this.dailyRentalCost = dailyRentalCost;
        this.status = VehicleStatus.ACTIVE;
        this.kmDriven = kmDriven;
        this.horsePower = horsePower;
    }

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getDailyRentalCost() {
        return dailyRentalCost;
    }

    public void setDailyRentalCost(double dailyRentalCost) {
        this.dailyRentalCost = dailyRentalCost;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public double getKmDriven() {
        return kmDriven;
    }

    public void setKmDriven(double kmDriven) {
        this.kmDriven = kmDriven;
    }

    public double getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(double horsePower) {
        this.horsePower = horsePower;
    }
}

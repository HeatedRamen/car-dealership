package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    Dealership(String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
        inventory = new ArrayList<>();
    }

    public ArrayList<Vehicle> getVehicleByPrice(double min, double max){ return null; }
    public ArrayList<Vehicle> getVehicleByMakeModel(String make, String model){ return null; }
    public ArrayList<Vehicle> getVehicleByYear(int min, int max){ return null; }
    public ArrayList<Vehicle> getVehicleByColor (String color){ return null; }
    public ArrayList<Vehicle> getVehicleByMileage(int min, int max){ return null; }
    public ArrayList<Vehicle> getVehicleByType(String vehicleType) { return null; }
    public ArrayList<Vehicle> getAllVehicle() { return inventory; }

    public void addVehicle(Vehicle vehicle){ inventory.add(vehicle); }
    public void removeVehicle(Vehicle vehicle){}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}

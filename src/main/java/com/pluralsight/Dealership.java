package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    Dealership(){
        name = "";
        address = "";
        phone = "";
        inventory = new ArrayList<>();
    }

    Dealership(String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
        inventory = new ArrayList<>();
    }

    public List<Vehicle> getVehicleByPrice(double min, double max){ return null; }
    public List<Vehicle> getVehicleByMakeModel(String make, String model){ return null; }
    public List<Vehicle> getVehicleByYear(int min, int max){ return null; }
    public List<Vehicle> getVehicleByColor (String color){ return null; }
    public List<Vehicle> getVehicleByMileage(int min, int max){ return null; }
    public List<Vehicle> getVehicleByType(String vehicleType) { return null; }
    public List<Vehicle> getAllVehicle() { return inventory; }

    public void addVehicle(Vehicle vehicle){ inventory.add(vehicle); }
    public void removeVehicle(Vehicle vehicle){}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }


    public void convertHeader(String headerLine){
        String[] parsedHeader = headerLine.split("\\|");

        name = (parsedHeader[0]);
        address = (parsedHeader[1]);
        phone = (parsedHeader[2]);
    }

    public void convertVehicle(String line){
        String[] parsedLine = line.split("\\|");

        inventory.add(new Vehicle(Integer.parseInt(parsedLine[0]), Integer.parseInt(parsedLine[1]), parsedLine[2], parsedLine[3],
                parsedLine[4], parsedLine[5], Integer.parseInt(parsedLine[6]), Double.parseDouble(parsedLine[7])));
    }

}

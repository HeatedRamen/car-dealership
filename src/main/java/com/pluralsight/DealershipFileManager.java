package com.pluralsight;

import java.io.*;


public class DealershipFileManager {

    public Dealership getDealership(){

        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("inventory.csv"));
            Dealership dealership = new Dealership();
            String line = "";

            dealership.convertHeader(bufReader.readLine());

            while ((line = bufReader.readLine()) != null){
                dealership.convertVehicle(line);
            }
            return dealership;
        }
        catch (Exception IOException){
            System.out.println("File not found.");
            return null;
        }
    }

    public void saveDealership(Dealership dealership){

        try{
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter("inventory.csv"));
            bufWriter.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());

            for (Vehicle vehicle : dealership.getAllVehicle()){
                bufWriter.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" +
                                    vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" +
                                    vehicle.getOdometer() + "|" + vehicle.getPrice());
            }
            bufWriter.close();
        }
        catch (Exception IOException){
            System.out.println("File not found!");
        }
    }

}
